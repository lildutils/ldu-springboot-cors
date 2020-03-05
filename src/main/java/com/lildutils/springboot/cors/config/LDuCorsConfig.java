package com.lildutils.springboot.cors.config;

import java.util.Set;

import com.lildutils.springboot.cors.whitelist.LDuCorsWhitelistProcessor;

public class LDuCorsConfig
{
	private String	allowedMethods;
	private String	allowedHeaders;
	private boolean	allowedCredentials;
	private int		expirationTime;
	private String	exposedHeaders;
	private String	whitelist;

	public LDuCorsConfig()
	{
		super();
	}

	public String getAllowedMethods()
	{
		return allowedMethods;
	}

	public void setAllowedMethods( String allowedMethods )
	{
		this.allowedMethods = allowedMethods;
	}

	public String getAllowedHeaders()
	{
		return allowedHeaders;
	}

	public void setAllowedHeaders( String allowedHeaders )
	{
		this.allowedHeaders = allowedHeaders;
	}

	public boolean getAllowedCredentials()
	{
		return allowedCredentials;
	}

	public void setAllowedCredentials( boolean allowedCredentials )
	{
		this.allowedCredentials = allowedCredentials;
	}

	public int getExpirationTime()
	{
		return expirationTime;
	}

	public void setExpirationTime( int expirationTime )
	{
		this.expirationTime = expirationTime;
	}

	public String getExposedHeaders()
	{
		return exposedHeaders;
	}

	public void setExposedHeaders( String exposedHeaders )
	{
		this.exposedHeaders = exposedHeaders;
	}

	public String getWhitelist()
	{
		return whitelist;
	}

	public Set<String> getWhitelistProcessed()
	{
		return LDuCorsWhitelistProcessor.run( getWhitelist() );
	}

	public void setWhitelist( String whitelist )
	{
		this.whitelist = whitelist;
	}

}
