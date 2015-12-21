package fr.u.bordeaux.classifiedAds.DAO;

//import java.util.Collections;
import java.util.List;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.*;

import fr.u.bordeaux.classifiedAds.Entity.Ad;

@Named
@Stateless
public class AdDAO {
	@PersistenceContext( unitName = "AdPersistanceUnit" )
	private EntityManager em;
	
	public List<Ad> getAllAds(){
		//System.out.println("getAllAds call");
		@SuppressWarnings("unchecked")
		//List<Ad> l = Collections.checkedList(em.createQuery("SELECT a from Ad a").getResultList(), Ad.class);
		List<Ad> l = em.createQuery("SELECT a from Ad a").getResultList();
		//System.out.println(l.toString());
		//System.out.println(l.toArray());

		//System.out.println("getAllAds end");
		return l;
	}
	public List<Ad> getLastAds(){
		return null;
		//TODO
	}
}
