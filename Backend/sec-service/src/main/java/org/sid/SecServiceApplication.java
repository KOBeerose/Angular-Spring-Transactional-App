package org.sid;

import org.sid.entities.AppRole;
import org.sid.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;
@EnableDiscoveryClient


@SpringBootApplication
public class SecServiceApplication {
    @LoadBalanced
    public static void main(String[] args) {

        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
     

        };}
        @Bean
        BCryptPasswordEncoder getBCPE(){
            return new BCryptPasswordEncoder();
        }
    }
