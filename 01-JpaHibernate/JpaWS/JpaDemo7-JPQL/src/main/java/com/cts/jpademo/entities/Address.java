package com.cts.jpademo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{

	private String adressLine1;
	private String adressLine2;
	private String state;
	private String country;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String adressLine1, String adressLine2, String state, String country) {
		super();
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.state = state;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressLine1 == null) ? 0 : adressLine1.hashCode());
		result = prime * result + ((adressLine2 == null) ? 0 : adressLine2.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (adressLine1 == null) {
			if (other.adressLine1 != null)
				return false;
		} else if (!adressLine1.equals(other.adressLine1))
			return false;
		if (adressLine2 == null) {
			if (other.adressLine2 != null)
				return false;
		} else if (!adressLine2.equals(other.adressLine2))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	public String getAdressLine1() {
		return adressLine1;
	}

	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	public String getAdressLine2() {
		return adressLine2;
	}

	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
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

	@Override
	public String toString() {
		return "Address [adressLine1=" + adressLine1 + ", adressLine2=" + adressLine2 + ", state=" + state
				+ ", country=" + country + "]";
	}
	
	
}
