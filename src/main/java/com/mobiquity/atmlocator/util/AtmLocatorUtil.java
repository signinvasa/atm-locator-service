package com.mobiquity.atmlocator.util;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmlocator.dto.Address;
import com.mobiquity.atmlocator.dto.Root;

public class AtmLocatorUtil {
		
	public List<Root> parseJsonString(String responseStr) throws JsonMappingException, JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		Root[] rootElements = objectMapper.readValue(responseStr, Root[].class);
		return Arrays.asList(rootElements);
	}
	
	public Root getDefaultAtm(){
		Root rootelement = new Root();
		Address atmAddress = new Address();
		atmAddress.setCity("deventer");
		rootelement.setAddress(atmAddress);
		return rootelement;
	}

}
