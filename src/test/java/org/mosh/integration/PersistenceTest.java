package org.mosh.integration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.joda.time.LocalDateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mosh.model.entity.Artist;
import org.mosh.model.entity.Concert;
import org.mosh.model.entity.Location;
import org.mosh.model.entity.repository.ArtistRepository;
import org.mosh.model.entity.repository.ConcertRepository;
import org.mosh.model.entity.repository.LocationRepository;
import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class PersistenceTest {

	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	ConcertRepository concertRepository;
	
	@Test
	public void testSessionSave() {

		// Create main artists
		Artist am = new Artist("ArcticMonkeys", CountryEnum.ENGLAND, new LocalDateTime(), false);
		Artist kasabian = new Artist("Kasabian",CountryEnum.ENGLAND,
				new LocalDateTime(), false);
		Artist spoon = new Artist("Spoon",CountryEnum.ENGLAND,
				new LocalDateTime(), false);

		// Save Kasabian and Spoon
		List<Artist> artistsRelatedTo = Lists.newArrayList();
		artistsRelatedTo.add(am);
		
		kasabian.setArtistsRelated(artistsRelatedTo);
		artistRepository.save(kasabian);
		spoon.setArtistsRelated(artistsRelatedTo);
		artistRepository.save(spoon);
		
		// Create AM Concert
		Location location = new Location();
		location.setCity("Buenos Aires");
		location.setCountry(CountryEnum.ARGENTINA);
		location.setType(LocationTypeEnum.STADIUM);
		locationRepository.save(location);
		
		Concert concert = new Concert();
		List<Artist> artistsPlaying = Lists.newArrayList();
		artistsPlaying.add(am);
		concert.setArtists(artistsPlaying);
		concert.setDate(new LocalDateTime());
		concert.setName("Personal Fest");
		concert.setLocation(location);
		
		// Set am related artists
		List<Artist> artists = Lists.newArrayList();
		artists.add(kasabian);
		artists.add(spoon);
		am.setArtistsRelated(artists);
		
		// Save modified objects
		artistRepository.save(am);
		concertRepository.save(concert);
//		session.getTransaction().commit();

		// Retrieve am concert
//		Query q = session.createQuery("From Concert");

//		List<Concert> concerts = q.list();
		List<Concert> concerts = (List<Concert>) concertRepository.findAll();
		Assert.assertTrue(concerts.size() == 1);
		Assert.assertTrue(concerts.get(0).getArtists().contains(am));
	}
	
	

}
