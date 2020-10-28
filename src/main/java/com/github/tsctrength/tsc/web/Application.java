package com.github.tsctrength.tsc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.setProperty("spring.data.mongodb.uri", "mongodb+srv://root:toor@cluster0.vmjuh.gcp.mongodb.net/tsc");
		SpringApplication.run(Application.class, args);
	}
}
