package org.saheb.register;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.saheb.filter.AuthenticationFilter;
 
public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        packages("org.saheb");
        register(LoggingFeature.class);
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}
	