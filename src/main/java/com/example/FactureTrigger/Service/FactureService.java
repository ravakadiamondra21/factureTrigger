package com.example.FactureTrigger.Service;

import org.springframework.stereotype.Service;

import com.example.FactureTrigger.Dto.FactureRequestDto;
import com.example.FactureTrigger.Model.Facture;
import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.FactureRepository;
import com.example.FactureTrigger.Repository.UserRepo;

@Service
public class FactureService {
	
	private final FactureRepository factureRepo;
	private final UserRepo userRepo;

	public FactureService(FactureRepository factureRepo, UserRepo userRepo) {
		super();
		this.factureRepo = factureRepo;
		this.userRepo = userRepo;
	}
	
	public Facture createFacture(FactureRequestDto dto, String userEmail) {
		User user = userRepo.findByUserEmail(userEmail).orElseThrow();
		
		Facture facture = new Facture();
		facture.setNom(dto.getNom());
		facture.setMontant(dto.getMontant());
		facture.setDate_facture(dto.getDate_facture());
		facture.setUser(user);
		
		return factureRepo.save(facture);
		
		
	}
	
}
