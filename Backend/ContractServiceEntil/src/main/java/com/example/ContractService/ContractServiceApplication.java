package com.example.ContractService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controllerService")
@ComponentScan("cont")
@EnableDiscoveryClient
public class ContractServiceApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(ContractServiceApplication.class, args);
	}

}
