package fr.u.bordeaux.classifiedAds.DAO;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.script.SimpleBindings;

import org.apache.openjpa.persistence.meta.Members.SetAttributeImpl;
import org.apache.openjpa.persistence.query.ParameterExpression;

import fr.u.bordeaux.classifiedAds.Entity.Ad;
import fr.u.bordeaux.classifiedAds.Entity.Address;
import fr.u.bordeaux.classifiedAds.Entity.User;

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
	@SuppressWarnings("unchecked")
	public List<Ad> getPublishedAds(User u){
		return em.createQuery("SELECT a from Ad a WHERE a.publisher = :p ORDER BY a.submissionDate, a.description DESC")
				.setParameter("p", u)
				.getResultList();
	}
	public List<Ad> getSavedAds(User u){
		List<Ad> l = new ArrayList<Ad>();
		List<Ad> p = (u.getSelecteddAds() != null) ? u.getSelecteddAds() : new ArrayList<Ad>();
		for (Ad ad : p) {
			l.add(em.find(Ad.class, ad.getId()));
		}
		return l;
	}
	public List<Ad> getCriteriasAds(User u, Ad max, Ad min, Ad o, int n){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ad> q = cb.createQuery(Ad.class);
		Root<Ad> from = q.from(Ad.class);
		Predicate where = cb.and();
		List<Order> order = new ArrayList<Order>();

		if(u != null){
		}
		if(max != null){
			if(max.getPrice() >= 0){
				Predicate p = cb.le(from.get("price"), max.getPrice());
				where = p;
			}
			if(max.getSurfaceArea() >= 0){
				Predicate p = cb.le(from.get("surfaceArea"), max.getSurfaceArea());
				where = cb.and(where, p);
			}			
		}
		if(min != null){
			if(min.getPrice() >= 0){
				Predicate p = cb.ge(from.get("price"), min.getPrice());
				where = cb.and(where, p);
			}
			if(min.getSurfaceArea() >= 0){
				Predicate p = cb.ge(from.get("surfaceArea"), min.getSurfaceArea());
				where = cb.and(where, p);
			}
			/*if(min.getAddress() != null){
				if(min.getAddress().getCountry() != null){
					Predicate p = cb.equal(from.get("address.country"), min.getAddress().getCountry());
					where = cb.and(where, p);
				}
				if(min.getAddress().getArea() != null){
					Predicate p = cb.equal(from.get("address"), min.getAddress().getArea());
					where = cb.and(where, p);
				}
			}*/			
		}	
		//ordering
		if(o != null){
			if(o.getPrice() >= 1){
			}
			if(o.getSubmissionDate()!= null){
			}
			if(o.getAddress() != null){
			}			
		}
		q.select(from).where(where).orderBy(order);
		TypedQuery<Ad> query = em.createQuery(q);
		List<Ad> l = query.getResultList();
		return l;//query.getResultList();
	}

	public void persist(Ad a){
		//UPDATE User's published adslist
		em.persist(a);
	}

}
