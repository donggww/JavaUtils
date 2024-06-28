package com.donggw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StartSpringEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartSpringEurekaApplication.class,args);

	}
}
