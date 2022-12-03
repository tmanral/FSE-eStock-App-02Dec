package com.cognizant.eserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EServiceRegistryApplication.class, args);
	}

}
