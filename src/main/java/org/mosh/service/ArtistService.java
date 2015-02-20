package org.mosh.service;

import java.util.List;

import org.mosh.model.entity.Artist;

public interface ArtistService {
	
	public Artist getArtistByName(String name);
	
	public List<Artist> getAllArtists();

	
}
