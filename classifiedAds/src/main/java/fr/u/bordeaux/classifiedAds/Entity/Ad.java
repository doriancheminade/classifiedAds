package fr.u.bordeaux.classifiedAds.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Ad")
public class Ad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 777382977710523368L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=200, nullable=false)
	private String description;
	
	@Column 
	private float surfaceArea;

	@ElementCollection
	private Set<byte[]> images;

	@Column(length=255)
	private long price;
	
	@Column(length=5)
	private String currency;
	
	@Column
	private Timestamp submissionDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Set<byte[]> getImages() {
		return images;
	}

	public void setImages(Set<byte[]> images) {
		this.images = images;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Timestamp submitionDate) {
		this.submissionDate = submitionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
