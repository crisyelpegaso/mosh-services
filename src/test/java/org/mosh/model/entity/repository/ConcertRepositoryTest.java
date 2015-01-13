package org.mosh.model.entity.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class ConcertRepositoryTest {

	@Autowired
	ConcertRepository concertRepository;
	
	@Test
	public void testRepositoryInjection(){
		Assert.assertNotNull(concertRepository);
	}
	
	
}
