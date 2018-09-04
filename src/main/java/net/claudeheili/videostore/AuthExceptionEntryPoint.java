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

public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {

		final Map<String, Object> mapBodyException = new HashMap<>();

		mapBodyException.put("message", new String("Username or password is incorrect"));

		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), mapBodyException);

	}
}