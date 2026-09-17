package com.example.leetcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;





@SpringBootApplication
@EnableCaching
public class LeetcodeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeDemoApplication.class, args);
	}

}
