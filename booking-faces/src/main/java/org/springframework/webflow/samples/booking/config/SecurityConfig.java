package org.springframework.webflow.samples.booking.config;

import org.springframework.context.annotation.Configuration;
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
			.requestCache()
				.requestCache(new HttpSessionRequestCache());
	}

	@Override
	@SuppressWarnings("deprecation")
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("keith").password("{MD5}417c7382b16c395bc25b5da1398cf076").roles("USER", "SUPERVISOR").and()
			.withUser("erwin").password("{MD5}12430911a8af075c6f41c6976af22b09").roles("USER", "SUPERVISOR").and()
			.withUser("jeremy").password("{MD5}57c6cbff0d421449be820763f03139eb").roles("USER").and()
			.withUser("scott").password("{MD5}942f2339bf50796de535a384f0d1af3e").roles("USER");
	}

}
