package com.integrator;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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
}
