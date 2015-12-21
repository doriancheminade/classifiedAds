package fr.u.bordeaux.classifiedAds.Controller;


import javax.ejb.EJB;
import javax.faces.bean.*;

import fr.u.bordeaux.classifiedAds.DAO.CredentialsDAO;
import fr.u.bordeaux.classifiedAds.Entity.User;

@ManagedBean
@SessionScoped
public class CredentialsCtrl {

	@EJB
	private CredentialsDAO dao;
	
	
	public User getUser(){
		return dao.getUser();
	}
	public boolean isLoggedIn(){
		return dao.isLoggedIn();
	}
	public String register(){
		dao.register();
		return "/login";
	}
	public String logout(){
		dao.logout();
		return "/login";
	}
	public void login(){
		dao.login();
	}	
}
