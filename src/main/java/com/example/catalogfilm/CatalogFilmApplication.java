package com.example.catalogfilm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class CatalogFilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogFilmApplication.class, args);
	}

}
