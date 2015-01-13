package org.mosh.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;

@Entity
public class Location {

	@Id
    @GeneratedValue
	private Long id;
	
	private String city;
	
	@Enumerated(EnumType.STRING)
	private CountryEnum country;
	
	@Enumerated(EnumType.STRING)
	private LocationTypeEnum type;
	
	private String name;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public CountryEnum getCountry() {
		return country;
	}
	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	public LocationTypeEnum getType() {
		return type;
	}
	public void setType(LocationTypeEnum type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
