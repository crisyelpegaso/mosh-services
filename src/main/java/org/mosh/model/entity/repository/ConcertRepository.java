package org.mosh.model.entity.repository;

import java.util.List;

import org.mosh.model.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long>{
	
	public List<Concert> findByName(String name);
}
