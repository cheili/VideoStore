package net.claudeheili.videostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import net.claudeheili.videostore.i18n.MessageByLocaleService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MessageByLocaleService messageByLocaleService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers(HttpMethod.POST, "/login")
				.permitAll().anyRequest().authenticated().and()
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager(), messageByLocaleService),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().authenticationEntryPoint(new AuthExceptionEntryPoint(messageByLocaleService));

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
				.password(passwordEncoder.encode("password")).roles("USER");
	}

}