package com.example.userapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
public class UserappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserappApplication.class, args);

	}

}
