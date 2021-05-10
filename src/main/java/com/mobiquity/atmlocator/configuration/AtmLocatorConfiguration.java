package com.mobiquity.atmlocator.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.mobiquity.atmlocator.util.AtmLocatorUtil;
/**
 * Configuration class which declares all the @Bean classes for dependency injection
 * 
 * @author Madanmohan Vasa
 */
@Configuration
public class AtmLocatorConfiguration {

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public AtmLocatorUtil getAtmLocatorUtil() {
		return new AtmLocatorUtil();
	}
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}