package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloud.dao")
public class SpringCloudOrdersProvider {
	
	public static  void main(String[] args) {
		SpringApplication.run(SpringCloudOrdersProvider.class, args);
	}

}
