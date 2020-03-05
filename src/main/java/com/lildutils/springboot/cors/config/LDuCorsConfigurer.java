package com.lildutils.springboot.cors.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lildutils.springboot.cors.filter.LDuCorsFilter;

@Configuration
@Order(100)
public class LDuCorsConfigurer extends WebSecurityConfigurerAdapter
{
	@Autowired
	private Environment environment;

	@Override
	protected void configure( HttpSecurity http ) throws Exception
	{
		super.configure( http );
		http.addFilterBefore( getCorsFilter(), UsernamePasswordAuthenticationFilter.class );
	}

	@Bean("CORSFilter")
	public Filter getCorsFilter()
	{
		final LDuCorsConfig config = new LDuCorsConfig();
		config.setWhitelist( environment.getProperty( "ldu.cors.allowed-origins" ) );
		config.setAllowedMethods( environment.getProperty( "ldu.cors.allowed-methods" ) );
		config.setAllowedHeaders( environment.getProperty( "ldu.cors.allowed-headers" ) );
		config.setExposedHeaders( environment.getProperty( "ldu.cors.exposed-headers" ) );
		config.setAllowedCredentials( environment.getProperty( "ldu.cors.allowed-credentials", Boolean.class ) );
		config.setExpirationTime( environment.getProperty( "ldu.cors.expiration-time", Integer.class ) );
		return new LDuCorsFilter( config );
	}

}
