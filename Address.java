package day0417;

import java.io.Serializable;

public class Address implements Serializable{
	
	String street;
	String country;
	transient String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", country=" + country + ", state=" + state + "]";
	}
	
	
	
}

