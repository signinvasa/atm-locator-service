package com.mobiquity.atmlocator.service;

import java.util.List;

import com.mobiquity.atmlocator.dto.Root;
/**
 * Interface that provides methods to fetch the ATMs information from ATMService
 * 
 * @author Madanmohan Vasa
 */
public interface AtmLocatorService {
	
	/**
	 * To locate all the available ATMs based of the given city
	 * @param city A name of the city
	 * @return The list of all ATMs available in that city
	 */
	public List<Root> locateAtm(String city);
	
	/**
	 * To locate all the available ATMs
	 * @return The list of all ATMs available
	 */
	public List<Root> locateAllAtms();
	
}
