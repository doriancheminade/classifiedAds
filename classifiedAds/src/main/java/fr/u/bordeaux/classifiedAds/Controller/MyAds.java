package fr.u.bordeaux.classifiedAds.Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.u.bordeaux.classifiedAds.DAO.AdDAO;
import fr.u.bordeaux.classifiedAds.Entity.Ad;
import fr.u.bordeaux.classifiedAds.Entity.User;

@ManagedBean
@ViewScoped
public class MyAds implements Serializable{
	private static final long serialVersionUID = -4027604995633423673L;

	@EJB
	private AdDAO addao;	

	private List<Ad> saved;
	private List<Ad> published;
	private User u;
	private int current;
	
	@PostConstruct
	public void init(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		u = (User) facesContext.getApplication()
				.evaluateExpressionGet(facesContext, "#{userCtrl.user}", User.class);
		saved = addao.getSavedAds(u);
		published = addao.getPublishedAds(u);
		current = 0;
		
		
	}

	public List<Ad> getSaved() {
		return saved;
	}

	public void setSaved(List<Ad> saved) {
		this.saved = saved;
	}

	public List<Ad> getPublished() {
		return published;
	}

	public void setPublished(List<Ad> published) {
		this.published = published;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	public void delete(){
		for (Ad ad : published) {
			if(ad.getId()==current){
				addao.delete(ad);
				published.remove(ad);
			}
		}
		
	}
}
