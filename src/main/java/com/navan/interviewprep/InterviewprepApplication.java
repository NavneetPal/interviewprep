package com.navan.interviewprep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InterviewprepApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewprepApplication.class, args);
	}

}
