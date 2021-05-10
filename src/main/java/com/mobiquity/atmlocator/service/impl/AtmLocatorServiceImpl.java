package com.mobiquity.atmlocator.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiquity.atmlocator.dto.Root;
import com.mobiquity.atmlocator.service.AtmLocatorService;
import com.mobiquity.atmlocator.service.AtmSevice;

/**
 * Implementation class to call the AtmSevice and fetch the ATMs info.
 * 
 * @author Madanmohan Vasa
 */
@Service
public class AtmLocatorServiceImpl implements AtmLocatorService {

	@Autowired
	AtmSevice atmSevice;

	@Override
	public List<Root> locateAtm(String city) {
		List<Root> responseList = locateAllAtms().stream()
				.filter(root -> root.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		return responseList;
	}

	@Override
	public List<Root> locateAllAtms() {
		return atmSevice.getAtmInfo();
	}

}
