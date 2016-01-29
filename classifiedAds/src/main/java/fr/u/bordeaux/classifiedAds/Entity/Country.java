package fr.u.bordeaux.classifiedAds.Entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Country implements Serializable{
	private static final long serialVersionUID = 2735683575382719882L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
