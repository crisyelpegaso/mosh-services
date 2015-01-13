package org.mosh.service;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.mosh.model.entity.Concert;
import org.mosh.model.entity.Location;

public interface ConcertsService {

	public List<Concert> getAllConcerts();
	
	public Concert getConcertsByDate(LocalDateTime localDateTime);
	
	public List<Concert> getConcertsByName(String name);
	
	public List<Concert> getConcertsByLocation(Location location);
	
}
