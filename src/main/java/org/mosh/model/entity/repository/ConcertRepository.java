package org.mosh.model.entity.repository;

import org.mosh.model.entity.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Long>{
	
}
