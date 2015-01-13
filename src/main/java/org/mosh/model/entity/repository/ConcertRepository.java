package org.mosh.model.entity.repository;

import org.mosh.model.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long>{
	
}
