package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springcloud.dao")  //设置Mybatis接口所在的位置
@SpringBootApplication
public class StringCloudGoodProvider {

	public static void main(String[] args) {
		SpringApplication.run(StringCloudGoodProvider.class, args);
		

	}

}
