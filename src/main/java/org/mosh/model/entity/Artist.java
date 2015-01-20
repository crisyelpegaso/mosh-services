package org.mosh.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.mosh.model.enums.CountryEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

@Entity
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
	
	private boolean isSoloist;
	
	@ManyToMany
	@NotEmpty
	@JsonIgnore
	private List<Artist> artistsRelated = Lists.newArrayList();
	
	public Artist(){
		
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artistsRelated == null) ? 0 : artistsRelated.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isSoloist ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
//		if (artistsRelated == null) {
//			if (other.artistsRelated != null)
//				return false;
//		} else if (!artistsRelated.equals(other.artistsRelated))
//			return false;
		if (country != other.country)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isSoloist != other.isSoloist)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
//		if (startDate == null) {
//			if (other.startDate != null)
//				return false;
//		} else if (!startDate.equals(other.startDate))
//			return false;
		return true;
	}

	
}


