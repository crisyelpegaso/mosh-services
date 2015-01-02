package org.mosh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDate;

@Entity
@Table
public class Artist {
	
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	private String country;
	
	private LocalDate startDate;
	
	private Boolean isSoloist;
	
	public Artist(String name, String country, LocalDate startDate, Boolean isSoloist){
		this.setName(name);
		this.setCountry(country);
		this.setStartDate(startDate);
		this.setSoloist(isSoloist);
	}
	
	@OneToMany(mappedBy="artist",cascade=CascadeType.ALL)
	private List<Artist> artistsRelated;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public boolean isSoloist() {
		return isSoloist;
	}
	public void setSoloist(boolean isSoloist) {
		this.isSoloist = isSoloist;
	}
	public List<Artist> getArtistsRelated() {
		return artistsRelated;
	}
	public void setArtistsRelated(List<Artist> artistsRelated) {
		this.artistsRelated = artistsRelated;
	}
	
	
	

}
