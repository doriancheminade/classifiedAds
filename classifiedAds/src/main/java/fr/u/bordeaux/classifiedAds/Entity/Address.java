package fr.u.bordeaux.classifiedAds.Entity;
import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String country;
	
	//french department, uk county, us state, ...
	@Column
	private String area;
	
	//street and street number
	@Column
	private String street;
	
	//other usefull informations
	@Column
	private String misc;
	
	

}
