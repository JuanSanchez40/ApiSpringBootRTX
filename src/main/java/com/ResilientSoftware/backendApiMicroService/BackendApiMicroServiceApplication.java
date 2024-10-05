package com.ResilientSoftware.backendApiMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BackendApiMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiMicroServiceApplication.class, args);
	}

}
