package fr.u.bordeaux.classifiedAds.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Image implements Serializable{

	private static final long serialVersionUID = 974710239195693147L;

	@Lob
	@Column
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
