package fr.u.bordeaux.classifiedAds.Entity;
import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Address implements Serializable{	
	private static final long serialVersionUID = 6725689302629347980L;

	@Column
	private String country;
	
	//french department, uk county, us state, ...
	@Column
	private String area;
	
	//street and street number
	@Column
	private String street;
	
	//other usefull informations
	@Column
	private String misc;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}
	
	

}
