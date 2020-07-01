package com.ejemplo.apringboot.app.peliculas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableWebSecurity
public class SpringbootServicioPeliculasApplication extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioPeliculasApplication.class, args);
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		UserDetails user = User.builder().username("user").password(passwordEncoder.encode("secret")).roles("USER")
				.build();
		UserDetails userAdmin = User.builder().username("admin").password(passwordEncoder.encode("secret"))
				.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, userAdmin);
	}

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/movie").authenticated().antMatchers("/movie-rating")
				.hasRole("ADMIN").and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}
}
