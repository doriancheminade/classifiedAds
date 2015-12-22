package fr.u.bordeaux.classifiedAds.DAO;

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
		@SuppressWarnings("unchecked")
		List<Ad> l = em.createQuery("SELECT a from Ad a").getResultList();
		return l;
	}
	/*
	 * returns n ads starting at the position where ad was in chronological order 
	 * (ads with the same submission date are ordered by description)
	 * starts from position 0 if ad is null
	 */
	@SuppressWarnings("unchecked")
	public List<Ad> getLastAds(Ad ad, int n){
		if(ad != null){
			return em.createQuery("SELECT a from Ad a WHERE a.submissionDate > :date ORDER BY a.submissionDate, a.description DESC")
					.setParameter("date", ad.getSubmissionDate())
					.getResultList();
		}
		return em.createQuery("SELECT a from Ad a ORDER BY a.submissionDate, a.description DESC")
				.getResultList();
	}
}
