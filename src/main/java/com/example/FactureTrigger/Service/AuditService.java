package com.example.FactureTrigger.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FactureTrigger.Model.Audit;
import com.example.FactureTrigger.Repository.AuditRepository;

@Service
public class AuditService {

	private final AuditRepository auditRepo;

	public AuditService(AuditRepository auditRepo) {
		super();
		this.auditRepo = auditRepo;
	}
	
	public List<Audit> getAllAudit() {
		
		return this.auditRepo.findAllByOrderByActionTimestampDesc();
	}
}
