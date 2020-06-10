package com.integrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.integrator")
public class IntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegratorApplication.class, args);
	}

}
