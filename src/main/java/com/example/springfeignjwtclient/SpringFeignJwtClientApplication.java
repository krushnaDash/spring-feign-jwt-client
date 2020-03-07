package com.example.springfeignjwtclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignJwtClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignJwtClientApplication.class, args);
	}

}
