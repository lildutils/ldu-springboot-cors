package com.lildutils.springboot.cors.whitelist;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class LDuCorsWhitelistProcessor
{
	public static Set<String> run( String whitelist )
	{
		final Set<String> allowedOrigins = new HashSet<>();
		if( StringUtils.isNotBlank( whitelist ) )
		{
			String[] whiteListItems = null;
			if( whitelist.contains( "," ) )
			{
				whiteListItems = whitelist.split( "," );
			}
			else
			{
				allowedOrigins.add( whitelist.trim() );
			}
			if( whiteListItems != null && whiteListItems.length > 0 )
			{
				for( int i = 0; i < whiteListItems.length; i++ )
				{
					String whiteListItem = whiteListItems[i];
					if( StringUtils.isNotBlank( whiteListItem ) )
					{
						allowedOrigins.add( whiteListItem.trim() );
					}
				}
			}
		}
		return allowedOrigins;
	}

}
