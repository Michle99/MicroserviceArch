package com.ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MessageReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageReceiverApplication.class, args);
	}

}
