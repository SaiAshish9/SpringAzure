package com.sai.Azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureApplication {

	@GetMapping("/message")
	public String message(){
		return "Azure Platform Deployment by Sai";
	}

	public static void main(String[] args) {
		SpringApplication.run(AzureApplication.class, args);
	}

}
