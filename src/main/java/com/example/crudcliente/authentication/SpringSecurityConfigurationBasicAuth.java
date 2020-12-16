package com.example.crudcliente.authentication;

/**
 * @author Thiago da Silva Moraes
 */

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thiago da Silva Moraes
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("comum").password("{noop}123456").roles("COMUM")
		.and()
		.withUser("admin").password("{noop}123456").roles("ADMIN", "COMUM");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and().csrf().disable()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
	}
}