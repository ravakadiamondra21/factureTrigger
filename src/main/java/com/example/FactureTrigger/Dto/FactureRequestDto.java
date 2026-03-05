package com.example.FactureTrigger.Dto;

import java.time.LocalDate;

public class FactureRequestDto {
	
	private String nom;
	private LocalDate date_facture;
	private long montant;
	
	
	public FactureRequestDto(String nom, LocalDate date_facture, long montant) {
		super();
		this.nom = nom;
		this.date_facture = date_facture;
		this.montant = montant;
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
