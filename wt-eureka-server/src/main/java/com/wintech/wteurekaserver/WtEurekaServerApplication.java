package com.wintech.wteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WtEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WtEurekaServerApplication.class, args);
	}

}
