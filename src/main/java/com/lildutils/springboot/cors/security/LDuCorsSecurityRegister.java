package com.lildutils.springboot.cors.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class LDuCorsSecurityRegister
{
	@Autowired
	@Qualifier("CORSFilter")
	private Filter corsFilter;

	public void run( HttpSecurity http )
	{
		http.addFilterBefore( corsFilter, UsernamePasswordAuthenticationFilter.class );
	}

}
