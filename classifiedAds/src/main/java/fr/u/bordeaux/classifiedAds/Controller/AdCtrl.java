package fr.u.bordeaux.classifiedAds.Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import fr.u.bordeaux.classifiedAds.DAO.AdDAO;
import fr.u.bordeaux.classifiedAds.DAO.ImageDAO;
import fr.u.bordeaux.classifiedAds.DAO.UserDAO;
import fr.u.bordeaux.classifiedAds.Entity.Ad;
import fr.u.bordeaux.classifiedAds.Entity.Address;
import fr.u.bordeaux.classifiedAds.Entity.Image;

@ManagedBean
@ViewScoped
public class AdCtrl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private AdDAO addao;

	@EJB
	private UserDAO userdao;
	
	@EJB
	private ImageDAO imageDAO;
	
	private Ad ad;

	@PostConstruct
	public void init(){
		ad = new Ad();
		if(ad.getAddress()==null)ad.setAddress(new Address());
		if(ad.getImages()==null)ad.setImages(new ArrayList<Image>());
	}

	public Ad getAd(){
		return ad;
	}
	public void setAd(Ad ad){
		this.ad = ad;
	}

	public void persist(){
		String key = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("publisherid");
		ad.setPublisher(userdao.findUser(key));
		for (Image i : ad.getImages()) {
			imageDAO.create(i);
		}
		addao.persist(ad);
	}
	
	private UploadedFile uploadedfile;

	public void handleImage() {
		List<Image> li = this.ad.getImages();
		Image i = new Image();
		try {
			i.setImage(IOUtils.toByteArray(uploadedfile.getInputstream()));
		} catch (IOException e) {
			e.printStackTrace();
		}//event.getFile().getContents());
		li.add(i);
		this.ad.setImages(li);
	}

	public UploadedFile getUploadedfile() {
		return uploadedfile;
	}

	public void setUploadedfile(UploadedFile uploadedfile) {
		this.uploadedfile = uploadedfile;
	}

	public void update(){
		addao.update(ad);
	}
	public void delete(){
		addao.delete(ad);
	}
	public void delete(Ad a){
		addao.delete(a);
	}
	public void find(long id){
		ad = addao.find(id);
	}
}
