package org.springframework.webflow.samples.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withUsername("keith").password("{MD5}417c7382b16c395bc25b5da1398cf076").roles("USER", "SUPERVISOR").build(),
				User.withUsername("erwin").password("{MD5}12430911a8af075c6f41c6976af22b09").roles("USER", "SUPERVISOR").build(),
				User.withUsername("jeremy").password("{MD5}57c6cbff0d421449be820763f03139eb").roles("USER").build(),
				User.withUsername("scott").password("{MD5}942f2339bf50796de535a384f0d1af3e").roles("USER").build());
	}

}
