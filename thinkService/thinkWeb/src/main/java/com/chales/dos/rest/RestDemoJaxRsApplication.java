package com.chales.dos.rest;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class RestDemoJaxRsApplication extends ResourceConfig {

	public RestDemoJaxRsApplication(){
		packages("com.chales.dos.facade");
		register(LoggingFilter.class);

        // register filters
        register(RequestContextFilter.class);
        register(LoggingResponseFilter.class);
        register(CORSResponseFilter.class);

          //register exception mappers
//        register(GenericExceptionMapper.class);
//        register(AppExceptionMapper.class);
//        register(NotFoundExceptionMapper.class);

        // register features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
	}
}
