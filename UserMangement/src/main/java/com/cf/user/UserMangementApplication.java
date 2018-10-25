package com.cf.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class UserMangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMangementApplication.class, args);
	}
}
