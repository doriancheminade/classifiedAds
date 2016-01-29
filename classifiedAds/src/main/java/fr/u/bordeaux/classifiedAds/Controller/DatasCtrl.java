package fr.u.bordeaux.classifiedAds.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.u.bordeaux.classifiedAds.DAO.AddressDAO;
import fr.u.bordeaux.classifiedAds.Entity.Area;
import fr.u.bordeaux.classifiedAds.Entity.Country;

@ManagedBean
@ViewScoped
public class DatasCtrl implements Serializable{
	private static final long serialVersionUID = -8366051986283513193L;
	private List<String> city;
	private List<String> country;
	
	@EJB
	private AddressDAO dao;
	
	@PostConstruct
	public void init(){
		city = new ArrayList<String>();
		country = new ArrayList<String>();
		List<Country> c = dao.getCountryList();
		for (Country fc : c) {
			country.add(fc.getName());
		}
		List<Area> a = dao.getAreaList();
		for (Area fa : a) {
			city.add(fa.getName());
		}
		/*
		city.add("");
		city.add("bordeaux");
		city.add("francfort");
		country.add("");
		country.add("france");
		country.add("allemagne");*/
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
