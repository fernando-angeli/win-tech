package com.wintech.wtoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.wintech.wtoauth.WtOauthApplication.class, args);
	}

}
