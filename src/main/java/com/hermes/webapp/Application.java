package com.hermes.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("repositories")
@EntityScan("domain")
@ComponentScan({"services", "controllers"})
@ImportResource("/spring-security.xml") // We can edit our security protocol here
public class Application {
	
	//OUR PROGRAM STARTS FROM HERE
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}