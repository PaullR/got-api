package com.got.gotapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GotApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotApiApplication.class, args);
	}
}
