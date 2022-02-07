package ma.fstt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGetwayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGetwayApplication.class, args);
	}
}
