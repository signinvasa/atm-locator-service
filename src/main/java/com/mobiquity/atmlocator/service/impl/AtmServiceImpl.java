package com.mobiquity.atmlocator.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mobiquity.atmlocator.controller.AtmLocatorController;
import com.mobiquity.atmlocator.dto.Root;
import com.mobiquity.atmlocator.exceptions.AtmLocatorException;
import com.mobiquity.atmlocator.service.AtmSevice;
import com.mobiquity.atmlocator.util.AtmLocatorUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Service implementation class to call the 3rd party api to fetch the ATMs
 * info.
 * 
 * @author Madanmohan Vasa
 */
@Service
public class AtmServiceImpl implements AtmSevice {

	private Logger log = LoggerFactory.getLogger(AtmServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AtmLocatorUtil util;

	@Value("${atmlocator.service.url}")
	String serviceUrl;

	@Override
	@Cacheable(ATM_INFO_CACHE)
	@HystrixCommand(fallbackMethod = "getDefaultAtmInfo")
	public List<Root> getAtmInfo() {
		/*
		 * if(true) { throw new RuntimeException("Not Available"); }
		 */
		log.info("Atm Service URL : " + serviceUrl);
		String serviceResponseStr = restTemplate.getForObject(serviceUrl, String.class);
		log.info("Before parsing the response string");

		// FIXME - Response string contains unwanted characters in the first 5
		// positions, removing them before parsing
		String responseStr = serviceResponseStr.substring(6, serviceResponseStr.length());
		log.info("After parsing the response string");

		List<Root> resultList = null;
		try {
			resultList = util.parseJsonString(responseStr);
			//addHateosFeature(resultList);
			log.info("Result list size :" + resultList.size());

		} catch (JsonProcessingException e) {

			log.info("Exception occured while parsing the response String :" + e.getMessage());
			throw new AtmLocatorException(e.getMessage());
		}

		return resultList;
	}
	public List<Root> getDefaultAtmInfo() {
		
		log.info("Calling fallback method : getDefaultAtmInfo()");
		return Arrays.asList(util.getDefaultAtm());
		
	}

}
