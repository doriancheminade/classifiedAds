package fr.u.bordeaux.classifiedAds.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = -5411478145833852072L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String mail;	
	
	@Column(nullable=false)
	private String password;
	
	@Column
	private String username;

	/*@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable*/
	@Embedded
	private Address address;
	
	@Column
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publisher")
	//@JoinColumn()
	private transient List<Ad> publishedAds;
	
	@ManyToMany(cascade = CascadeType.ALL)
	//@JoinColumn()
	private transient List<Ad> selecteddAds;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		System.out.println("SET MAIL "+mail);
		System.out.println("SET MAIL \n"+this);
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Ad> getPublishedAds() {
		return publishedAds;
	}

	public void setPublishedAds(List<Ad> publishedAds) {
		this.publishedAds = publishedAds;
	}

	public List<Ad> getSelecteddAds() {
		return selecteddAds;
	}

	public void setSelecteddAds(List<Ad> selecteddAds) {
		this.selecteddAds = selecteddAds;
	}
	
}