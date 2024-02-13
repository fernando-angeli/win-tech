package com.fernandoangeli.win;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WtComponentesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WtComponentesServiceApplication.class, args);
	}

}
