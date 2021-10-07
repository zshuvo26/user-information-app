package com.example.userapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
public class UserappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserappApplication.class, args);

	}

}
