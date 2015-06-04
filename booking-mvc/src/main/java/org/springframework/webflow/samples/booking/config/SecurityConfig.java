package org.springframework.webflow.samples.booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/loginProcess")
				.defaultSuccessUrl("/hotels/search")
				.failureUrl("/login?login_error=1")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logoutSuccess");
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
