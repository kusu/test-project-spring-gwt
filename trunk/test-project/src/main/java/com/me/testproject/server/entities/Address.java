package com.me.testproject.server.entities;

import javax.persistence.Entity;

@Entity
public class Address extends AbstractEntity<Long> {

	/**
	 * @author kusum
	 */
	private static final long serialVersionUID = -229256067881950049L;

	private String firstLine;
	private String street;
	private String city;
	private String state;
	private String country;

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
