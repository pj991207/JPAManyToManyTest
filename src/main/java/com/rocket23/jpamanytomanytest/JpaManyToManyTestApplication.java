package com.rocket23.jpamanytomanytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaManyToManyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManyTestApplication.class, args);
	}

}
