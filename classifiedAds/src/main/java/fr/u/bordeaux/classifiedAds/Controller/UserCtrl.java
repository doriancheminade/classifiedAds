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
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
}
