package org.mosh.model.entity.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mosh.model.entity.Location;
import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class LocationRepositoryTest {

	@Autowired
	LocationRepository locationRepository;
	
	@Test
	public void testLocationRepositoryInjection(){
		Assert.assertNotNull(locationRepository);
	}
	
	@Test
	public void testSaveLocation(){
		Location location = new Location();
		location.setCity("London");
		location.setCountry(CountryEnum.ENGLAND);
		location.setType(LocationTypeEnum.STADIUM);
	}
}
