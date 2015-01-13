package org.mosh.controller;

import java.util.List;

import org.mosh.model.entity.Concert;
import org.mosh.service.ConcertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concerts")
public class ConcertsController {
	
	@Autowired
	ConcertsService concertsService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public @ResponseBody List<Concert> getConcerts(){
		return concertsService.getAllConcerts();
	}

}
