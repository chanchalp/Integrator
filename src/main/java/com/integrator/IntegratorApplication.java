package com.integrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@ComponentScan(basePackages = "com.integrator")
public class IntegratorApplication {


    private static final String CAMEL_URL_MAPPING = "/*";
    private static final String CAMEL_SERVLET_NAME = "CamelServlet";
    
	public static void main(String[] args) {
		SpringApplication.run(IntegratorApplication.class, args);
	}

	/*
	 * @Bean public ServletRegistrationBean servletRegistrationBean() {
	 * ServletRegistrationBean registration = new ServletRegistrationBean(new
	 * CamelHttpTransportServlet(), CAMEL_URL_MAPPING);
	 * registration.setName(CAMEL_SERVLET_NAME); return registration; }
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter = 
	        new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	}
}
