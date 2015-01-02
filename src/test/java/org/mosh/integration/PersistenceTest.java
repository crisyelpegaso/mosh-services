package org.mosh.integration;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.mosh.hibernate.util.HibernateUtil;
import org.mosh.model.Artist;

public class PersistenceTest {

	@Test
	public void testSessionSave() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Artist artist = new Artist("Arctic monkeys", "England",
				new LocalDate(), false);

		session.save(artist);

		session.getTransaction().commit();

		Query q = session.createQuery("From Artist ");

		List<Artist> resultList = q.list();
		System.out.println("num of artists:" + resultList.size());
	}

}
