package com.zz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zz.feign.HelloFeign;

@RestController
public class HelloController {

	//注入Feign接口
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "hahaFallback")
	public String hello(@PathVariable String name){
		return helloFeign.hello(name);
//		"This is Comsumer Feign Hystrix:"+
	}
	
	@RequestMapping("/eat/{name}")
	@HystrixCommand(fallbackMethod = "hahaFallback")
	public String eat(@PathVariable String name){
		return "This is my lunch"+helloFeign.eat(name);
	}
	
	//对应上面的方法，参数必须一致，当访问失败时，hystrix直接回调用此方法
	public String hahaFallback(String name){
		return "Ha Ha This Is Default Value";	//失败调用时，返回默认值
	}
	
}
