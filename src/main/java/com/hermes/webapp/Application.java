package com.hermes.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@ComponentScan("controllers")
//@Enable Repositories("")
//@EntityScan("")
//@ImportResource("")
@SpringBootApplication
@ImportResource("/spring-security.xml") // We can edit our security protocol here
public class Application {
	
	//OUR PROGRAM STARTS FROM HERE
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

}