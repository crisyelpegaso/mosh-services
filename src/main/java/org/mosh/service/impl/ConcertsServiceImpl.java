package org.mosh.service.impl;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.mosh.model.entity.Concert;
import org.mosh.model.entity.Location;
import org.mosh.model.entity.repository.ConcertRepository;
import org.mosh.service.ConcertsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertsServiceImpl implements ConcertsService {

	final Logger logger = LoggerFactory.getLogger(ConcertsServiceImpl.class);

	@Autowired
	ConcertRepository concertRepository;
	
	public List<Concert> getAllConcerts(){
		
		List<Concert> concerts =concertRepository.findAll();
		logger.info("Concerts found {}", concerts.size());
		return concerts;
	}

	public Concert getConcertsByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Concert> getConcertsByLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Concert getConcertsByDate(LocalDateTime localDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Concert> getConcertsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Concert> getConcertsByLocation(Location location) {
		// TODO Auto-generated method stub
		return null;
	}
}
