package org.mosh.model.entity.repository;

import java.util.List;

import org.mosh.model.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long>{
	
	public List<Concert> findByName(String name);
	
	@Query("select c from Concert c join c.artists artist where (artist.name=:paramName) or c.name like CONCAT('%', :paramName, '%')")
	public List<Concert> findByParamName(@Param(value = "paramName") String paramName);
}
