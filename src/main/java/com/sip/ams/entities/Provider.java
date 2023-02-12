package com.sip.ams.entities;
//import   static com.sip.ams.controllers.Stagiaire.*;
public class Provider extends Object {
	
	private String name;
	
	private String email;
	
	private String adresse;
	
	private int id;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	

	public Provider() {
		super();
	}

	@Override
	public String toString() {
		return "Provider [id =" +id +", name=" + name + ", email=" + email + ", adresse=" + adresse + ",  description="
				+ description + "]";
	}

	public Provider(int id,String name, String email, String adresse, String description) {
		super();
		this.name = name;
		this.email = email;
		this.adresse = adresse;
		this.id = id;
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
