package com.testdemo.eazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
//@EnableJpaRepositories("com.testdemo.easy.repository")
//@EntityScan("com.testdemo.easy")
public class EazyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyApplication.class, args);
	}

}
