package com.example.FactureTrigger.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_facture")
	private int numFacture;
	
	@Column
	private String nom;
	
	@Column
	private LocalDate date_facture;
	
	@Column
	private long montant;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	public Facture(int num_facture, String nom, LocalDate date_facture, long montant) {
		super();
		this.numFacture = num_facture;
		this.nom = nom;
		this.date_facture = date_facture;
		this.montant = montant;
	}

	public Facture() {
		super();
	}

	public int getNum_facture() {
		return numFacture;
	}

	public void setNum_facture(int num_facture) {
		this.numFacture = num_facture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate_facture() {
		return date_facture;
	}

	public void setDate_facture(LocalDate date_facture) {
		this.date_facture = date_facture;
	}

	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
