package com.example.FactureTrigger.Dto;

import java.time.LocalDate;

public class FactureDto {
	private int id_facture;
	private String nom;
	private LocalDate date_facture;
	private long montant;
	
	public FactureDto(int id_facture, String nom, LocalDate date_facture, long montant) {
		super();
		this.id_facture = id_facture;
		this.nom = nom;
		this.date_facture = date_facture;
		this.montant = montant;
	}

	public FactureDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_facture() {
		return id_facture;
	}

	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
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
