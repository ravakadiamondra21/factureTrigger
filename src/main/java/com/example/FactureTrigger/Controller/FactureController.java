package com.example.FactureTrigger.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FactureTrigger.Dto.FactureRequestDto;
import com.example.FactureTrigger.Model.Facture;
import com.example.FactureTrigger.Service.FactureService;

@RestController
@RequestMapping("/facture")
public class FactureController {

	private final FactureService factureService;

	public FactureController(FactureService factureService) {
		super();
		this.factureService = factureService;
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/create")
	public Facture createFacture(@RequestBody FactureRequestDto dto, Authentication auth) {
		
		String useremail = auth.getName();
		
		return this.factureService.createFacture(dto, useremail);
	}
}
