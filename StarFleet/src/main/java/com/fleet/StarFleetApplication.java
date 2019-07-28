package com.fleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.fleet"})
@EntityScan("com.fleet")
public class StarFleetApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarFleetApplication.class, args);
	}

}
