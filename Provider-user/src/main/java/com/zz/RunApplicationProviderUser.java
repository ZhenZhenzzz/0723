package com.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//启动Eureka客户端
public class RunApplicationProviderUser {
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplicationProviderUser.class, args);
	}

}
