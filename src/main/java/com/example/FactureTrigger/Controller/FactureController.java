package com.example.FactureTrigger.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FactureTrigger.Dto.FactureDto;
import com.example.FactureTrigger.Dto.FactureRequestDto;
import com.example.FactureTrigger.Model.Facture;
import com.example.FactureTrigger.Service.FactureService;

@RestController
@RequestMapping("/facture")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
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
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/update/{num_facture}")
	public Facture updateFacture(@RequestBody FactureRequestDto dto, @PathVariable int num_facture, Authentication auth) {
		String useremail = auth.getName();
		
		return this.factureService.updateFacture(dto, num_facture, useremail);
	}
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/delete/{num_facture}")
	public void deleteFacture(@PathVariable int num_facture) {
		this.factureService.deleteFacture(num_facture);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/findAll")
	public List<FactureDto> findAllFacture() {
		return this.factureService.getAllFacture();
	}
	
	
	
	
	
	
	
	
}
