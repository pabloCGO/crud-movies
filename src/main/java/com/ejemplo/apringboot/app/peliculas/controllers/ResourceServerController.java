package com.ejemplo.apringboot.app.peliculas.controllers;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class ResourceServerController extends ResourceServerConfigurerAdapter {

	  @Override
			public void configure(HttpSecurity http) throws Exception {
				http
				.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**").permitAll();
				http.requestMatchers().antMatchers("/movie")
				.and().authorizeRequests()
				.antMatchers("/movie").access("hasRole('USER')")
				.and().requestMatchers().antMatchers("/movie-rating")
				.and().authorizeRequests()
				.antMatchers("/movie-rating").access("hasRole('ADMIN')");
			}   
}
