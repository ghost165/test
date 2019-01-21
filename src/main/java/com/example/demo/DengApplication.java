package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.controller,com.example.service.impl" })
@MapperScan(value = "com.example.mapper")
public class DengApplication {

	public static void main(String[] args) {
		SpringApplication.run(DengApplication.class, args);
	}

}

