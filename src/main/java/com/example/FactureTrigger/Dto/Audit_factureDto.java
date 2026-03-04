package com.example.FactureTrigger.Dto;

import java.time.LocalDateTime;

import com.example.FactureTrigger.Enums.Action;

public class Audit_factureDto {
	private int id_audit;
	private Action type_action;
	private LocalDateTime date_maj;
	private long ancien_montant;
	private long nouveau_montant;
	private int facture;
	private int user;
	
	public Audit_factureDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audit_factureDto(int id_audit, Action type_action, LocalDateTime date_maj, long ancien_montant,
			long nouveau_montant, int facture, int user) {
		super();
		this.id_audit = id_audit;
		this.type_action = type_action;
		this.date_maj = date_maj;
		this.ancien_montant = ancien_montant;
		this.nouveau_montant = nouveau_montant;
		this.facture = facture;
		this.user = user;
	}

	public int getId_audit() {
		return id_audit;
	}

	public void setId_audit(int id_audit) {
		this.id_audit = id_audit;
	}

	public Action getType_action() {
		return type_action;
	}

	public void setType_action(Action type_action) {
		this.type_action = type_action;
	}

	public LocalDateTime getDate_maj() {
		return date_maj;
	}

	public void setDate_maj(LocalDateTime date_maj) {
		this.date_maj = date_maj;
	}

	public long getAncien_montant() {
		return ancien_montant;
	}

	public void setAncien_montant(long ancien_montant) {
		this.ancien_montant = ancien_montant;
	}

	public long getNouveau_montant() {
		return nouveau_montant;
	}

	public void setNouveau_montant(long nouveau_montant) {
		this.nouveau_montant = nouveau_montant;
	}

	public int getFacture() {
		return facture;
	}

	public void setFacture(int facture) {
		this.facture = facture;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	
	
}
