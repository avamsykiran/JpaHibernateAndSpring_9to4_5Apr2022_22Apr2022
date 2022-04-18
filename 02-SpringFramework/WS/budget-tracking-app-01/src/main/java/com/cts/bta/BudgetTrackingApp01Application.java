package com.cts.bta;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BudgetTrackingApp01Application {

	public static void main(String[] args) {
		SpringApplication.run(BudgetTrackingApp01Application.class, args);
	}

	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
}
