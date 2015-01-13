package org.mosh.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mosh.model.entity.repository.ConcertRepository;
import org.mosh.service.impl.ConcertsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-test.xml")
public class ConcertsServiceTest {

	@Autowired
	@InjectMocks
	ConcertsServiceImpl concertsService;
	
	@Mock
	ConcertRepository concertRepository;
	
	@Before
	public void init(){
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testServiceInjection(){
		Assert.assertNotNull(concertsService);
	}
	
	@Test
	public void testServiceAttributesInjection(){
		concertsService.getAllConcerts();
		verify(concertRepository, times(1)).findAll();
	}
}
