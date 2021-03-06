package com.trivia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.trivia"})
@EnableJpaRepositories(basePackages = {"com.trivia"})
@EntityScan(basePackages = {"com.trivia"})
public class TriviaApiApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(TriviaApiApplication.class, args);
	}
}
