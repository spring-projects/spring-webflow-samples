package org.springframework.webflow.samples.booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.formLogin()
				.loginPage("/spring/login")
				.loginProcessingUrl("/spring/loginProcess")
				.defaultSuccessUrl("/spring/main")
				.failureUrl("/spring/login?login_error=1")
				.and()
			.logout()
				.logoutUrl("/spring/logout")
				.logoutSuccessUrl("/spring/logoutSuccess")
				.and()

			// Disable CSRF (won't work with JSF) but ensure last HTTP POST request is saved
			// See https://jira.springsource.org/browse/SEC-2498

			.csrf().disable()
			.requestCache()
				.requestCache(new HttpSessionRequestCache());

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(new Md5PasswordEncoder())
			.withUser("keith").password("417c7382b16c395bc25b5da1398cf076").roles("USER", "SUPERVISOR").and()
			.withUser("erwin").password("12430911a8af075c6f41c6976af22b09").roles("USER", "SUPERVISOR").and()
			.withUser("jeremy").password("57c6cbff0d421449be820763f03139eb").roles("USER").and()
			.withUser("scott").password("942f2339bf50796de535a384f0d1af3e").roles("USER");
	}

}
