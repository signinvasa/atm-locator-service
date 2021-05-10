package com.mobiquity.atmlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mobiquity.atmlocator.configuration.AtmLocatorConfiguration;

/**
 * Main Springboot application class 
 * 
 * @author Madanmohan Vasa
 */

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableHystrix
@Import(AtmLocatorConfiguration.class)
public class AtmLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmLocatorApplication.class, args);
	}

}
