package com.atassian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.atassian")
public class AtlassianApiTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlassianApiTestingApplication.class, args);
	}

}
