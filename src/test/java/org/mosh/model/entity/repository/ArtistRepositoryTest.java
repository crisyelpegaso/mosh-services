package org.mosh.model.entity.repository;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mosh.model.entity.Artist;
import org.mosh.model.enums.CountryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class ArtistRepositoryTest {

	@Autowired
	ArtistRepository artistRepository;
	
	@Test
	public void testArtistRepositoryInjection(){
		Assert.assertNotNull(artistRepository);
	}
	
	@Test
	public void testSaveArtist(){
		Artist am = new Artist("ArcticMonkeys", CountryEnum.ENGLAND, new LocalDateTime(), false);
		am.setArtistsRelated(null);
		am = artistRepository.save(am);
		List<Artist> artistsSaved = artistRepository.findByName("ArcticMonkeys");
		Assert.assertTrue(!artistsSaved.isEmpty());
		Assert.assertTrue(artistsSaved.get(0).equals(am));
	}
}
