package fr.u.bordeaux.classifiedAds.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.u.bordeaux.classifiedAds.DAO.AdDAO;
import fr.u.bordeaux.classifiedAds.Entity.Ad;
import fr.u.bordeaux.classifiedAds.Entity.Address;
import fr.u.bordeaux.classifiedAds.Entity.User;

@ManagedBean
@ViewScoped
public class AdsCtrl implements Serializable{
	private static final long serialVersionUID = -4027604995633423673L;

	@EJB
	private AdDAO addao;	

	private List<Ad> ads;

	//criterias
	private User u;
	private Ad max;
	private Ad min;
	private Ad order;
	private int resNumber;

	@PostConstruct
	public void init(){
		ads = new ArrayList<Ad>();

		u = new User();
		max = new Ad();
		max.setAddress(new Address());
		max.setPrice(10000000);
		max.setSurfaceArea(1000000);
		min = new Ad();
		min.setAddress(new Address());
		order = new Ad();
		order.setAddress(new Address());
		resNumber = 24;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public void persist(Ad a){
		addao.persist(a);
	}

	public void loadMore(){
		ads.addAll(addao.getCriteriasAds(u, max, min, order, resNumber));		
	}
	public void search(){
		ads = addao.getCriteriasAds(u, max, min, order, resNumber);
	}
	public void lastads(){
		ads = addao.getLastAds(null, resNumber);
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Ad getMax() {
		return max;
	}

	public void setMax(Ad max) {
		this.max = max;
	}

	public Ad getMin() {
		return min;
	}

	public void setMin(Ad min) {
		this.min = min;
	}

	public Ad getOrder() {
		return order;
	}

	public void setOrder(Ad order) {
		this.order = order;
	}

	public int getResNumber() {
		return resNumber;
	}

	public void setResNumber(int resNumber) {
		this.resNumber = resNumber;
	}
}
