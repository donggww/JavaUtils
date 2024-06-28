package com.donggw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartSpringCloudApplication.class,args);
	}
}
