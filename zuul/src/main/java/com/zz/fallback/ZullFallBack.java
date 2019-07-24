package com.zz.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

//未被实例化，可通过包扫描加载。但是既不属于Controller，也不属于Service 所以使用@Component
@Component
public class ZullFallBack implements ZuulFallbackProvider {

//	获取路由 application.name-->Provider-User :provider-user ，同yaml文件配置。
	public String getRoute() {
		// TODO Auto-generated method stub
		return "provider-user";
	}

//	设置返回值，通常用Json体现，utf-8防止中文乱码
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {//匿名内部类

			
//			请求响应头信息        contentType和字符类型
			public HttpHeaders getHeaders() {
				// 返回类型为Json，设置字符集为UTF-8
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}


//			响应体，具体返回内容，就是Hystrix断路器设定，断路时显示的默认内容
			public InputStream getBody() throws IOException {
				String defaultValue = "Default Value!";//标准应为Json字符串
				return new ByteArrayInputStream(defaultValue.getBytes());
			}
			
//			返回文字描述====固定内容 
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
//			返回状态码
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST;
			}

//			返回二进制状态码
			public int getRawStatusCode() throws IOException {
				// 可不写
				return 0;
			}



//			关闭释放资源
			public void close() {
				// 可不写
				
			}
			
		};
	}

}
