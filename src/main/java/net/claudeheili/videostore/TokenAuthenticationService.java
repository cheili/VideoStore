package net.claudeheili.videostore;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
class TokenAuthenticationService {

	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	@Autowired
	private MessageSource messageSource;

	static void addAuthentication(HttpServletResponse httpServletResponse, String username) throws IOException {

		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

		String responseToClient = "{\"id\": 1, \"username\": \"" + username + "\", \"token\": \"" + JWT + "\"}";

		httpServletResponse.setContentType("application/json");

		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.getWriter().write(responseToClient);
		httpServletResponse.getWriter().flush();
		httpServletResponse.getWriter().close();

	}

	static Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}

		return null;
	}
}
