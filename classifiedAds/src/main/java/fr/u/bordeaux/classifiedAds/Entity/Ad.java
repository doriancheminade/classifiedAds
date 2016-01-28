package fr.u.bordeaux.classifiedAds.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import org.primefaces.event.FileUploadEvent;

@Entity
@Table(name="Ad")
public class Ad implements Serializable{
	private static final long serialVersionUID = 777382977710523368L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn()
	//private transient User publisher;
	private User publisher;
	
	@Column(length=200, nullable=false)
	private String description;
	
	@Column 
	private float surfaceArea;

	@ElementCollection
	@CollectionTable(joinColumns=@JoinColumn(name="ad_id"))
	//@Column()
	private List<Image> images;

	@Column(length=255)
	private long price;
	
	@Column(length=5)
	private String currency;
	
	@Column
	private Timestamp submissionDate;
	
	/*@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable*/
	@Embedded
	private Address address;
	
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

	public List<Image> getImages() {
		return images;
	}

	public void handleImage(FileUploadEvent event) {
		System.out.println("UPLOAD");
		Image i = new Image();
		i.setImage(event.getFile().getContents());
		this.images.add(i);
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Image getImage() {
		return images.get(images.size()-1);
	}

	public void setImage(Image image) {
		this.images.add(image);
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

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
