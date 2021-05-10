package com.mobiquity.atmlocator.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.mobiquity.atmlocator.dto.Root;

/**
 * Test class to test the AtmLocatorService functionality.
 * 
 * @author Madanmohan Vasa
 */
@SpringBootTest
public class AtmServiceTest {
	
	@Autowired
	AtmLocatorService atmLocatorService;
	
	@Test
	public void shouldFetchAllatms() {
		
		List<Root> result = atmLocatorService.locateAllAtms();
		Assert.notEmpty(result, "Result should contain atms list");
	}
	
	@Test
	public void shouldFetchAtmsForACity() {
		
		List<Root> result = atmLocatorService.locateAtm("deventer");
		Assert.notEmpty(result, "Result should contain atms list");
	}
	
	@Test
	public void shouldEmptyListIfCityIsNotValid() {
		
		List<Root> result = atmLocatorService.locateAtm("xyz");
		Assert.isTrue(result.isEmpty(), "Result should not contain atms");
	}
	

}
