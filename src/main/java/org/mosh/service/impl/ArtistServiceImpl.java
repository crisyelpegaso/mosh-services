package org.mosh.service.impl;

import org.mosh.model.entity.Artist;
import org.mosh.model.entity.repository.ArtistRepository;
import org.mosh.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtistServiceImpl implements ArtistService {

	@Autowired
	ArtistRepository artistRepository;
	
	@Override
	public Artist getArtistByName(String name) {
		return artistRepository.findByName(name);
	}
	

}
