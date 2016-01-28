package fr.u.bordeaux.classifiedAds.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.u.bordeaux.classifiedAds.Entity.User;

public class UserConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		//id -> object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		if(arg2==null) return new User();
		User u = em.find(User.class, arg2);
		return u;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		//object -> id
		if(arg2==null) return "";
		return Long.toString(((User)arg2).getId());
	}

}
