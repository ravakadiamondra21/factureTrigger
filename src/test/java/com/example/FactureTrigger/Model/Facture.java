package com.example.FactureTrigger.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_facture;
	
	@Column
	private String nom;
	
	@Column
	private LocalDate date_facture;
	
	@Column
	private long montant;
	
	@OneToMany(mappedBy = "facture")
	private List<Audit_facture> audit_facture;

	public Facture(int num_facture, String nom, LocalDate date_facture, long montant) {
		super();
		this.num_facture = num_facture;
		this.nom = nom;
		this.date_facture = date_facture;
		this.montant = montant;
	}

	public Facture() {
		super();
	}

	public int getNum_facture() {
		return num_facture;
	}

	public void setNum_facture(int num_facture) {
		this.num_facture = num_facture;
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
	
	
}
