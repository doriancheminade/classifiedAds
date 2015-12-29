package fr.u.bordeaux.classifiedAds.Controller;

import javax.ejb.EJB;
import javax.faces.bean.*;

import fr.u.bordeaux.classifiedAds.DAO.UserDAO;
import fr.u.bordeaux.classifiedAds.Entity.User;

@ManagedBean
@SessionScoped
public class UserCtrl {
	@EJB
	private UserDAO dao;
	
	
	public User getUser(){
		return dao.getUser();
	}
	public boolean isLoggedIn(){
		return dao.isLoggedIn();
	}
	public String register(){
		dao.register();
		return "";
	}
	public String logout(){
		dao.logout();
		return "";
	}
	public String login(){
		dao.login();
		return "";
	}	
	public String update(){
		dao.update();
		return "";
	}
}
