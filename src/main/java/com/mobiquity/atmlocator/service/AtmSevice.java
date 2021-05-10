package com.mobiquity.atmlocator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobiquity.atmlocator.dto.Root;

/**
 * Interface that provides method to get the ATMs information from 3rd pary
 * 
 * @author Madanmohan Vasa
 */
@Service
public interface AtmSevice {

	public static final String ATM_INFO_CACHE = "atmInformation";

	/**
	 * Fetches all ATMs from 3rd party application
	 * 
	 * @return The list of all ATMs information
	 */
	public List<Root> getAtmInfo();

}
