package com.andile.creditCards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan
public class CreditCardsApplication {


	public static void main(String[] args) {
		SpringApplication springApplication= new
				SpringApplication(SpringBootConfiguration.class);
		springApplication.addListeners(new ApplicationPidFileWriter()); // register PID write to spring boot. It will write PID to file
		SpringApplication.run(CreditCardsApplication.class, args);
	}
}
