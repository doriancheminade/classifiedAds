package fr.u.bordeaux.classifiedAds.DAO;

import java.util.List;

//import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;

import fr.u.bordeaux.classifiedAds.Entity.User;

@Stateful
//@LocalBean
public class UserDAO {
	private boolean log;
	private User user;

	@PersistenceContext( unitName = "AdPersistanceUnit" )
	private EntityManager em;

	@PostConstruct
	public void init(){
		user = new User();
		log = false;
	}	
	@SuppressWarnings("unchecked")
	public String login(){
		List<User> l = em.createQuery(
				"SELECT u FROM User u WHERE u.mail=:mail AND u.password=:password")
				.setParameter("mail", user.getMail())
				.setParameter("password", user.getPassword())
				.getResultList();
		if(!l.isEmpty()){
			user = l.get(0);
			log = true;
		}
		return "/login";
	}
	public String register(){
		em.persist(user);
		return "/login";
	}
	@Remove
	public String logout(){
		log = false;
		return "/login";
	}
	public boolean isLoggedIn(){
		return log;
	}
	public void update(){
		em.merge(user);
	}
	
	public String getMail() {
		return user.getMail();
	}
	public void setMail(String mail) {
		user.setMail(mail);
	}
	public String getPassword() {
		return user.getPassword();
	}
	public void setPassword(String password) {
		user.setPassword(password); 
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
