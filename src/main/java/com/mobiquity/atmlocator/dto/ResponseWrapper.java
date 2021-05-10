package com.mobiquity.atmlocator.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Wrapper class to inclue the list of ATMs. It will be wrapped in ResponseEntity and send to the client as the result 
 * 
 * @author Madanmohan Vasa
 */
@XmlRootElement
public class ResponseWrapper {

	private List<Root> atms;
	
	public ResponseWrapper() {
		//Default constructor
	}
	
	public ResponseWrapper(List<Root> atms) {
		this.atms = atms;
	}

	public List<Root> getAtms() {
		return atms;
	}

	public void setAtms(List<Root> atms) {
		this.atms = atms;
	}

}
