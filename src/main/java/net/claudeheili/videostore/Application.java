package net.claudeheili.videostore;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

//	@Configuration
//	@Order(SecurityProperties.BASIC_AUTH_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/home", "/login").permitAll()
//					.anyRequest().authenticated();
//		}
//	}
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
}