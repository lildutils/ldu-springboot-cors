package com.lildutils.springboot.cors.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lildutils.springboot.cors.filter.LDuCorsFilter;

@Configuration
public class LDuCorsWebSecurityConfigurer
{
	@Autowired
	private LDuCorsFilter corsFilter;

	public void configure( HttpSecurity http ) throws Exception
	{
		http.addFilterBefore( corsFilter, UsernamePasswordAuthenticationFilter.class );
	}

}
