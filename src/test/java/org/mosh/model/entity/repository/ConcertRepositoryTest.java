package org.mosh.model.entity.repository;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mosh.model.entity.Artist;
import org.mosh.model.entity.Concert;
import org.mosh.model.entity.Location;
import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class ConcertRepositoryTest {

	@Autowired
	ConcertRepository concertRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	
	@Autowired
	ArtistRepository artistRepository;
	
	Artist blur;
	
	@Before
	public void init(){
		blur = new Artist();
		blur.setCountry(CountryEnum.ENGLAND);
		blur.setName("Blur");
		blur.setSoloist(false);
		blur.setStartDate(new LocalDateTime());
		artistRepository.save(blur);
	}
	
	@Test
	public void testRepositoryInjection(){
		Assert.assertNotNull(concertRepository);
	}
	
	@Test
	public void testFindByParamNameArtistName(){
		List<Concert> concerts = concertRepository.findByParamName("Kasabian");
		Assert.assertNotNull(concerts);
		Assert.assertTrue(concerts.size() > 1);
		Assert.assertTrue("Kasabian".equals(concerts.get(0).getArtists().get(0).getName()));
	}
	
	@Test
	public void testFindByParamNameConcertName(){
		List<Concert> concerts = concertRepository.findByParamName("palu");
		Assert.assertNotNull(concerts);
		Assert.assertTrue(concerts.size() > 1);
		Assert.assertTrue("Lolapaluza".equals(concerts.get(0).getName()));
	}
	
	@Test
	public void saveConcert(){
		Location location = new Location();
		location.setCity("Buenos Aires");
		location.setCountry(CountryEnum.ARGENTINA);
		location.setName("GEBA");
		location.setType(LocationTypeEnum.STADIUM);
		locationRepository.save(location);
		
		Artist kasabian = new Artist();
		kasabian.setCountry(CountryEnum.ENGLAND);
		kasabian.setName("Kasabian");
		kasabian.setSoloist(false);
		kasabian.setStartDate(new LocalDateTime());
		
		List<Artist> artistsRelatedToKasabian =Lists.newArrayList();
		artistsRelatedToKasabian.add(blur);
		kasabian.setArtistsRelated(artistsRelatedToKasabian);
		
		List<Artist> artistsRelatedToBlur =Lists.newArrayList();
		artistsRelatedToBlur.add(kasabian);
		blur.setArtistsRelated(artistsRelatedToBlur);

		
		List<Artist> artistsPlaying =Lists.newArrayList();
		artistsPlaying.add(kasabian);
		
		Concert concert = new Concert();
		concert.setDate(new LocalDateTime());
		concert.setLocation(location);
		concert.setArtists(artistsPlaying);
		concert.setName("Lolapaluza");
		List<Concert> concerts = Lists.newArrayList();
		concerts.add(concert);
		kasabian.setConcerts(concerts);
		artistRepository.save(kasabian);
		concertRepository.save(concert);
	}
	
	
}
