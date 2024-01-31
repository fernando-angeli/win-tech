package com.wintech.wtapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WtApiGatewayApplication.class, args);
	}

}
