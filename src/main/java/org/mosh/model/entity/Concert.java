package org.mosh.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.mosh.deserializer.CustomDateJsonDateDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Concert {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@NotBlank
	private String name;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime date;
	
	@OneToOne
	private Location location;
	
	@NotEmpty
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		      name="Concert_Artist",
		      joinColumns={@JoinColumn(name="Artist_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="Concert_id", referencedColumnName="ID")})
	private List<Artist> artists;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonSerialize(using=CustomDateJsonDateDeserializer.class)
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

}
