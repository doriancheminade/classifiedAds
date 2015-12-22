package fr.u.bordeaux.classifiedAds.Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.u.bordeaux.classifiedAds.DAO.AdDAO;
import fr.u.bordeaux.classifiedAds.Entity.Ad;

@ManagedBean
@ViewScoped
public class AdCtrl implements Serializable{
	private static final long serialVersionUID = -4027604995633423673L;

	@EJB
	private AdDAO addao;
	
	private List<Ad> ads;
	
	@PostConstruct
	public void init(){
		ads = addao.getLastAds(null, 10);
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
	
}
