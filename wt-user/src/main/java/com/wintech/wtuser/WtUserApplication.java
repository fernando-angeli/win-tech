package com.wintech.wtuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WtUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(WtUserApplication.class, args);
	}

}
