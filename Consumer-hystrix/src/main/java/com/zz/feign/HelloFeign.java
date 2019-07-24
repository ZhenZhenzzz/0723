package com.zz.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="provider-user")//provider的yaml文件里配置的
public interface HelloFeign {

	//接口方法
	/*
	 * Feign中没有原生的@GetMapping/@PostMapping/@DeleteMapping/@PutMapping，
	 * 需要指定需要用method进行
	 */
	@RequestMapping(value="/hello/{name}")
//	@RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
	public String hello(@PathVariable("name") String name);
	
	@RequestMapping(value="/eat/{name}")
	public String eat(@PathVariable("name") String name);
}
