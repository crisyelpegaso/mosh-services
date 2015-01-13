package org.mosh.model.entity.repository;

import java.util.List;

import org.mosh.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

	public List<Artist> findByName(String name);
}
