package org.mosh.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.mosh.model.enums.CountryEnum;

import com.google.common.collect.Lists;

@Entity
@Table
public class Artist {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@NotBlank
	private String name;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private CountryEnum country;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	private LocalDateTime startDate;
	
	private Boolean isSoloist;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@NotEmpty
	private List<Artist> artistsRelated = Lists.newArrayList();
	
	public Artist(String name, CountryEnum country, LocalDateTime startDate, Boolean isSoloist){
		this.setName(name);
		this.setCountry(country);
		this.setStartDate(startDate);
		this.setSoloist(isSoloist);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CountryEnum getCountry() {
		return country;
	}
	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
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

