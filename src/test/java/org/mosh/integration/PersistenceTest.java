package org.mosh.integration;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.mosh.hibernate.util.HibernateUtil;
import org.mosh.model.entity.Artist;
import org.mosh.model.entity.Concert;
import org.mosh.model.entity.Location;
import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;

import com.google.common.collect.Lists;

public class PersistenceTest {

	@Test
	public void testSessionSave() {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

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
		session.save(kasabian);
		spoon.setArtistsRelated(artistsRelatedTo);
		session.save(spoon);
		
		// Create AM Concert
		Location location = new Location();
		location.setCity("Buenos Aires");
		location.setCountry(CountryEnum.ARGENTINA);
		location.setType(LocationTypeEnum.STADIUM);
		session.save(location);
		
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
		session.save(am);
		session.save(concert);
		session.getTransaction().commit();

		// Retrieve am concert
		Query q = session.createQuery("From Concert");

		List<Concert> concerts = q.list();
		Assert.assertTrue(concerts.size() == 1);
		Assert.assertTrue(concerts.get(0).getArtists().contains(am));
	}

}
