package com.example.FactureTrigger.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	@Column
	private String user_email;
	
	@Column
	private String user_name;
	
	@OneToMany(mappedBy = "user")
	private List<Audit_facture> audit_facture;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id_user, String user_email, String user_name) {
		super();
		this.id_user = id_user;
		this.user_email = user_email;
		this.user_name = user_name;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
