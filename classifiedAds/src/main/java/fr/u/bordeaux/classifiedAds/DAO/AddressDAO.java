package fr.u.bordeaux.classifiedAds.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.u.bordeaux.classifiedAds.Entity.Country;
import fr.u.bordeaux.classifiedAds.Entity.Area;

@Stateless
public class AddressDAO {
	@PersistenceContext( unitName = "AdPersistanceUnit" )
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Country> getCountryList() {
		return em.createQuery("SELECT a from Country a").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Area> getAreaList() {
		return em.createQuery("SELECT a from Area a").getResultList();
	}
}
