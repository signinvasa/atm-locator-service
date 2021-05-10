package com.mobiquity.atmlocator.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquity.atmlocator.dto.ResponseWrapper;
import com.mobiquity.atmlocator.dto.Root;
import com.mobiquity.atmlocator.exceptions.AtmLocatorException;
import com.mobiquity.atmlocator.service.AtmLocatorService;

/**
 * Controller class which will be invoked when "api/v1/locator" is mentioned in the url
 * This is the end point for the outside world
 * 
 * @author Madanmohan Vasa
 */
@RestController
@RequestMapping("api/v1/locator")
public class AtmLocatorController {

	@Autowired
	AtmLocatorService locatorService;

	@GetMapping(value = "/atms", produces = { "application/json", "application/xml" })
	public ResponseEntity<ResponseWrapper> locateAtms(@RequestParam(required = false)  Optional<String> city) {
		try {

			List<Root> responseList = null;
			if (city.isPresent()) {
				responseList = locatorService.locateAtm(city.get());
			} else {
				responseList = locatorService.locateAllAtms();
			}
			addHateoasFeature(responseList);
			ResponseWrapper wrapper = new ResponseWrapper(responseList);
			ResponseEntity<ResponseWrapper> response = new ResponseEntity<ResponseWrapper>(wrapper, HttpStatus.OK);
			return response;

		} catch (Exception e) {
			throw (new AtmLocatorException(e.getMessage()));
		}
	}
	
	private void addHateoasFeature(List<Root> responseList ) {
		responseList.forEach(atm->{
			if(atm.getLinks().isEmpty()) {
			  Link selfLink = linkTo(methodOn(AtmLocatorController.class).locateAtms(Optional.of(atm.getAddress().getCity()))).withSelfRel();
			  atm.add(selfLink);
			}
		});
	}
}
