package org.mosh.service.impl;

import java.util.List;

import org.mosh.model.entity.Artist;
import org.mosh.model.entity.repository.ArtistRepository;
import org.mosh.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	ArtistRepository artistRepository;
	
	public Artist getArtistByName(String name) {
		return artistRepository.findByName(name);
	}
	
	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}
	

}
