package com.traini8.trainingcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.traini8.trainingcenter")
public class TrainingCenterRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCenterRegistryApplication.class, args);
	}
}
