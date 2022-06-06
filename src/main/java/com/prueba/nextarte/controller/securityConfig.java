package com.prueba.nextarte.controller;

import java.time.Duration;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.prueba.nextarte.service.authConfig.UserDetailService;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	@Autowired
	private UserDetailService detailService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public 	BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws 	Exception{
//		auth.inMemoryAuthentication()
//		.withUser("user")
//		.password("987654321")
//		.roles("USER")
//		.and()
//		.withUser("admin")
//		.password("admin")
//		.roles("USER","ADMIN");
		
		auth.userDetailsService(detailService).passwordEncoder(encoder);
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
	 http
	 .authorizeRequests()
	 .anyRequest()
	 .authenticated()
	 .and()
	 .httpBasic();
	 
	 http
	 .csrf().disable();
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
	

}
