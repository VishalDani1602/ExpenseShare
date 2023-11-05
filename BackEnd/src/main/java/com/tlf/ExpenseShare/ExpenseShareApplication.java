package com.tlf.ExpenseShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ExpenseShareApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpenseShareApplication.class, args);
	}

}
