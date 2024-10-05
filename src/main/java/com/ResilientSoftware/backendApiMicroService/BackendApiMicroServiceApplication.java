package com.ResilientSoftware.backendApiMicroService;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.ResilientSoftware.backendApiMicroService.repository")
public class BackendApiMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiMicroServiceApplication.class, args);
	}
}
