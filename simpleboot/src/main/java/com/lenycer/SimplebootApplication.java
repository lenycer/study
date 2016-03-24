package com.lenycer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lenycer.sample.SampleBeans;

@SpringBootApplication
public class SimplebootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplebootApplication.class, args);
	}
	/*
	@Bean
	public SampleBeans sampleBeans() {
		return new SampleBeans();
	}
	*/
	
}
