package org.mosh.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.mosh.model.enums.CountryEnum;
import org.mosh.model.enums.LocationTypeEnum;

@Entity
public class Location {

	@Id
    @GeneratedValue
	private Long id;
	
	@NotBlank
	private String city;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private CountryEnum country;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private LocationTypeEnum type;
	
	@NotBlank
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