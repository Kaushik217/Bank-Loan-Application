package com.techm.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@OpenAPIDefinition
public class BankLoanTraineeApplication
{
	public static void main(String[] args) {
		SpringApplication.run(BankLoanTraineeApplication.class, args);
		System.out.println("Hello World");
	}

}
