package net.claudeheili.videostore;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.claudeheili.videostore.i18n.MessageByLocaleService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private MessageByLocaleService messageByLocaleService;

	public JWTLoginFilter(String url, AuthenticationManager authManager) {

		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	public JWTLoginFilter(String url, AuthenticationManager authenticationManager,
			MessageByLocaleService messageByLocaleService) {

		this(url, authenticationManager);

		this.messageByLocaleService = messageByLocaleService;

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws JsonGenerationException, JsonMappingException, IOException {

		AccountCredentials creds = null;

		try {

			creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);

			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), Collections.emptyList()));

		} catch (IOException e) {

			final Map<String, Object> mapBodyException = new HashMap<>();

			String message = messageByLocaleService.getMessage("user.login.nocredentials", req);

			mapBodyException.put("message", message);
			res.setContentType("application/json");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			final ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getOutputStream(), mapBodyException);
			
			return null;
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		TokenAuthenticationService.addAuthentication(res, auth.getName());
	}
}