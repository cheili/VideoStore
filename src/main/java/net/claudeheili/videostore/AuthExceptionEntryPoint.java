package net.claudeheili.videostore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.claudeheili.videostore.i18n.MessageByLocaleService;

public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

	private MessageByLocaleService messageByLocaleService;

	public AuthExceptionEntryPoint(MessageByLocaleService messageByLocaleService) {

		super();
		this.messageByLocaleService = messageByLocaleService;
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {

		final Map<String, Object> mapBodyException = new HashMap<>();
		
		String message = messageByLocaleService.getMessage("user.login.invalid", request);

		mapBodyException.put("message", message);

		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), mapBodyException);

	}
}