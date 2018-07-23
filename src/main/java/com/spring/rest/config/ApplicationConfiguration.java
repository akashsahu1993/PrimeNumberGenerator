package com.spring.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class ApplicationConfiguration {

	 @Autowired
	  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
	    ObjectMapper objectMapper = builder.createXmlMapper(false).build();

	    // Some other custom configuration for supporting Java 8 features
	    /*objectMapper.registerModule(new Jdk8Module());
	    objectMapper.registerModule(new JavaTimeModule());
*/
	    // Use property
	    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

	    return objectMapper;
	  }
}
