package fr.u.bordeaux.classifiedAds.Entity;

import javax.persistence.*;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String mail;
	
	@Column
	private String username;
	
	@Column(nullable=false)
	private String password;

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
	
}