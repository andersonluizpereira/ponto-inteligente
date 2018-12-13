package com.ads.pontointeligente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@EnableCaching
@ActiveProfiles("test")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
