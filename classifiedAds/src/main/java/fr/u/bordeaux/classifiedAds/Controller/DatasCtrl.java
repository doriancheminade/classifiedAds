package fr.u.bordeaux.classifiedAds.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DatasCtrl implements Serializable{
	private List<String> city;
	private List<String> country;
	
	@PostConstruct
	public void init(){
		city = new ArrayList<String>();
		country = new ArrayList<String>();
		city.add("");
		city.add("bordeaux");
		city.add("francfort");
		country.add("");
		country.add("france");
		country.add("allemagne");
	}
	
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> cities) {
		this.city = cities;
	}
	public List<String> getCountry() {
		return country;
	}
	public void setCountry(List<String> country) {
		this.country = country;
	}
}
