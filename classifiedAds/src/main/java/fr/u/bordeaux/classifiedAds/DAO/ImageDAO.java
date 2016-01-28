package fr.u.bordeaux.classifiedAds.DAO;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.u.bordeaux.classifiedAds.Entity.Image;

@Named
@Stateless
public class ImageDAO {

	@PersistenceContext( unitName = "AdPersistanceUnit" )
	private EntityManager em;

	public void create(Image i){
		em.persist(i);
	}

	public void edit(Image i){
		em.merge(i);
	}

	public void remove(Image i){
		em.remove(em.merge(i));
	}

	public Image find(Object id){
		return em.find(Image.class, id);
	}
}
