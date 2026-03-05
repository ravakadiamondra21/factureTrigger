package com.example.FactureTrigger.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit")
public class Audit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_audit;

    private String username;
    private String action_type;
    
    @Column(name = "action_timestamp")
    private LocalDateTime actionTimestamp;
    
    private String host_name;
    private Integer facture_id;
    private Double montant_ancien;
    private Double montant_nouveau;
    
	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audit(Long id_audit, String username, String action_type, LocalDateTime action_timestamp, String host_name,
			Integer facture_id, Double montant_ancien, Double montant_nouveau) {
		super();
		this.id_audit = id_audit;
		this.username = username;
		this.action_type = action_type;
		this.actionTimestamp = action_timestamp;
		this.host_name = host_name;
		this.facture_id = facture_id;
		this.montant_ancien = montant_ancien;
		this.montant_nouveau = montant_nouveau;
	}

	public Long getId_audit() {
		return id_audit;
	}

	public void setId_audit(Long id_audit) {
		this.id_audit = id_audit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAction_type() {
		return action_type;
	}

	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}

	public LocalDateTime getAction_timestamp() {
		return actionTimestamp;
	}

	public void setAction_timestamp(LocalDateTime action_timestamp) {
		this.actionTimestamp = action_timestamp;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public Integer getFacture_id() {
		return facture_id;
	}

	public void setFacture_id(Integer facture_id) {
		this.facture_id = facture_id;
	}

	public Double getMontant_ancien() {
		return montant_ancien;
	}

	public void setMontant_ancien(Double montant_ancien) {
		this.montant_ancien = montant_ancien;
	}

	public Double getMontant_nouveau() {
		return montant_nouveau;
	}

	public void setMontant_nouveau(Double montant_nouveau) {
		this.montant_nouveau = montant_nouveau;
	}
    
    
}
