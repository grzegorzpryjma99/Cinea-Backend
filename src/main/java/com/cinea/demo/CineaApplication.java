package com.cinea.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class CineaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineaApplication.class, args);
	}

}
