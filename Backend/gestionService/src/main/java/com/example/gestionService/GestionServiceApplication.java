package com.example.gestionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


@SpringBootApplication
@EnableDiscoveryClient
public class GestionServiceApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(GestionServiceApplication.class, args);
	}
}
