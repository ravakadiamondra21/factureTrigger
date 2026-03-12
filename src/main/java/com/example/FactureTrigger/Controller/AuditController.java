package com.example.FactureTrigger.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FactureTrigger.Dto.CountingAuditDto;
import com.example.FactureTrigger.Model.Audit;
import com.example.FactureTrigger.Service.AuditService;

@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class AuditController {
	
	private final AuditService service;

	public AuditController(AuditService service) {
		super();
		this.service = service;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	public List<Audit> getAllAudit() {
		return this.service.getAllAudit();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/count")
	public List<CountingAuditDto> countingAudit() {
		return this.service.countingAudit();
	}

}
