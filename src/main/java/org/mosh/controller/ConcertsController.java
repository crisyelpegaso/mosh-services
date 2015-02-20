package org.mosh.controller;

import java.util.List;

import org.mosh.model.entity.Concert;
import org.mosh.service.ConcertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/concerts")
public class ConcertsController {
	
	@Autowired
	ConcertsService concertsService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Concert> getConcerts(){
		return concertsService.getAllConcerts();
	}
	
	@RequestMapping(method=RequestMethod.GET, params="name")
	public @ResponseBody List<Concert> getConcertsByName(@RequestParam(value = "name", required = true) String name){
		return concertsService.getConcertsByParamName(name);
	}

}
