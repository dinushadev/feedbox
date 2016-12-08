package com.dns.feedbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("/integration.xml")
@SpringBootApplication
public class FeedbooxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbooxApplication.class, args);
	}
}
