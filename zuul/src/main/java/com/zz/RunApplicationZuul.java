package com.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication    //项目架构
@EnableZuulProxy		//标志API网关
@EnableEurekaClient		//Eureka客户端
public class RunApplicationZuul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RunApplicationZuul.class, args);
	}

}
