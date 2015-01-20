package org.mosh.model.entity.repository;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mosh.model.entity.Artist;
import org.mosh.model.enums.CountryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		Artist artistSaved = artistRepository.findByName("ArcticMonkeys");
		Assert.assertNotNull(artistSaved);
		Assert.assertTrue(artistSaved.equals(am));
	}
}
