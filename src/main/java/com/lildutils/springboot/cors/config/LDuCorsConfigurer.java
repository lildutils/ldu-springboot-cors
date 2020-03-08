package com.lildutils.springboot.cors.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.lildutils.springboot.cors.filter.LDuCorsFilter;
import com.lildutils.springboot.cors.security.LDuCorsSecurityRegister;

@Configuration
@ComponentScan(basePackageClasses = LDuCorsSecurityRegister.class)
public class LDuCorsConfigurer
{
	@Autowired
	private Environment environment;

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
