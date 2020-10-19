package com.vim.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.vim.test")
@EnableMongoRepositories(basePackages="com.vim.test.repository")
public class SpringBootDemo {

	public static void main(String[] args) {
	SpringApplication.run(SpringBootDemo.class, args);
	}

}
