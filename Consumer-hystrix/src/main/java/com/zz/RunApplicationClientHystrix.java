package com.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringCloudApplication
@EnableFeignClients//支持Feign接口
@EnableCircuitBreaker//启动Hystrix
public class RunApplicationClientHystrix {

	public static void main(String[] args) {
		SpringApplication.run(RunApplicationClientHystrix.class, args);
	}
}
