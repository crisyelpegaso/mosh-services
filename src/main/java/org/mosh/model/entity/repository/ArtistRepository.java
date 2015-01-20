package org.mosh.model.entity.repository;

import org.mosh.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

	public Artist findByName(String name);
}
