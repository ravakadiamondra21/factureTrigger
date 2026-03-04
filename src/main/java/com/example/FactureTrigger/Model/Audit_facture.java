package com.example.FactureTrigger.Model;

import java.time.LocalDateTime;

import com.example.FactureTrigger.Enums.Action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Audit_facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_audit;
	
	@Column
	private Action type_action;
	
	@Column
	private LocalDateTime date_maj;
	
	@Column
	private long ancien_montant;
	
	@Column
	private long nouveau_montant;
	
	@ManyToOne
	@JoinColumn(name = "id_facture")
	private Facture facture;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Audit_facture(int id_audit, Action type_action, LocalDateTime date_maj, long ancien_montant,
			long nouveau_montant, Facture facture, User user) {
		super();
		this.id_audit = id_audit;
		this.type_action = type_action;
		this.date_maj = date_maj;
		this.ancien_montant = ancien_montant;
		this.nouveau_montant = nouveau_montant;
		this.facture = facture;
		this.user = user;
	}

	public Audit_facture() {
		super();
		// TODO Auto-generated constructor stub
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

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
