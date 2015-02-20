package org.mosh.controller;

import java.util.List;

import org.mosh.model.entity.Artist;
import org.mosh.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
	ArtistService artistService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Artist> getConcerts(){
		return artistService.getAllArtists();
	}
	
	@RequestMapping(method=RequestMethod.GET, params="name")
	public @ResponseBody Artist getConcertsByName(@RequestParam(value = "name", required = true) String name){
		return artistService.getArtistByName(name);
	}

}
