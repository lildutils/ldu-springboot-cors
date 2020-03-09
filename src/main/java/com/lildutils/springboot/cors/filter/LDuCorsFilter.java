package com.lildutils.springboot.cors.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lildutils.springboot.cors.config.LDuCorsConfig;

public class LDuCorsFilter extends OncePerRequestFilter
{
	private final Set<String>	allowedOrigins;
	private final String		allowedMethods;
	private final String		allowedHeaders;
	private final boolean		allowedCredentials;
	private final int			expiration;
	private final String		exposedHeaders;

	public LDuCorsFilter( LDuCorsConfig config )
	{
		super();
		this.allowedMethods = config.getAllowedMethods();
		this.allowedHeaders = config.getAllowedHeaders();
		this.allowedCredentials = config.getAllowedCredentials();
		this.expiration = config.getExpirationTime();
		this.exposedHeaders = config.getExposedHeaders();
		this.allowedOrigins = config.getWhitelistProcessed();
	}

	@Override
	protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain )
			throws IOException, ServletException
	{
		final String origin = request.getHeader( "Origin" );

		if( !allowedOrigins.contains( origin ) )
		{
			response.setStatus( HttpStatus.FORBIDDEN.value() );
			response.setCharacterEncoding( StandardCharsets.UTF_8.name() );
			logger.warn( "CORS Failed! " + request.getMethod() + " " + request.getRequestURL() + " | Origin: " + origin );
			return;
		}

		response.addHeader( "Access-Control-Allow-Origin", origin );
		response.addHeader( "Access-Control-Allow-Methods", allowedMethods );
		response.addHeader( "Access-Control-Allow-Headers", allowedHeaders );
		response.addHeader( "Access-Control-Expose-Headers", exposedHeaders );
		response.addHeader( "Access-Control-Allow-Credentials", String.valueOf( allowedCredentials ) );
		response.addHeader( "Access-Control-Max-Age", String.valueOf( expiration ) );
		logger.info( "CORS Success! " + request.getMethod() + " " + request.getRequestURL() + " | Origin: " + origin );

		filterChain.doFilter( request, response );
	}

}
