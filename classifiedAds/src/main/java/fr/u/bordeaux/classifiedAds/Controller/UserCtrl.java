package fr.u.bordeaux.classifiedAds.Controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.*;

import fr.u.bordeaux.classifiedAds.DAO.AdDAO;
import fr.u.bordeaux.classifiedAds.DAO.UserDAO;
import fr.u.bordeaux.classifiedAds.Entity.Ad;
import fr.u.bordeaux.classifiedAds.Entity.User;

@ManagedBean
@SessionScoped
public class UserCtrl {
	@EJB
	private UserDAO dao;
	@EJB
	private AdDAO addao;


	public User getUser(){
		return dao.getUser();
	}
	public void setUser(User u){
		dao.setUser(u);
	}
	public boolean isLoggedIn(){
		return dao.isLoggedIn();
	}
	public void register(){
		dao.register();
	}
	public void logout(){
		dao.logout();
	}
	public void login(){
		dao.login();
	}	
	public void update(){
		dao.update();
	}
	public UserDAO getDAO(){
		return dao;
	}
	public List<Ad> getUsersAds() {
		return addao.getPublishedAds(dao.getUser());
		//return dao.getUser().getPublishedAds();
	}
	public List<Ad> getSavedAds() {
		return addao.getSavedAds(dao.getUser());
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
}
