package com.example.FactureTrigger.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.FactureTrigger.Controller.DatabaseUserSessionManager;
import com.example.FactureTrigger.Dto.FactureDto;
import com.example.FactureTrigger.Dto.FactureRequestDto;
import com.example.FactureTrigger.Model.Facture;
import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.FactureRepository;
import com.example.FactureTrigger.Repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class FactureService {
	
	private final FactureRepository factureRepo;
	private final UserRepo userRepo;
	private final DatabaseUserSessionManager sessionManager;

	public FactureService(FactureRepository factureRepo, UserRepo userRepo, DatabaseUserSessionManager sessionManager) {
		super();
		this.factureRepo = factureRepo;
		this.userRepo = userRepo;
		this.sessionManager = sessionManager;
	}
	
	@Transactional
	public Facture createFacture(FactureRequestDto dto, String userEmail) {
		
		sessionManager.setCurrentUserInDB();
		
		User user = userRepo.findByUserEmail(userEmail).orElseThrow();
		
		Facture facture = new Facture();
		facture.setNom(dto.getNom());
		facture.setMontant(dto.getMontant());
		facture.setDate_facture(dto.getDate_facture());
		facture.setUser(user);
		
		return factureRepo.save(facture);
		
		
	}
	
	
	@Transactional
	public Facture updateFacture(FactureRequestDto newdto, int num_facture, String userEmail) {
		
		sessionManager.setCurrentUserInDB();
		
		User user = userRepo.findByUserEmail(userEmail).orElseThrow();
		
		Facture oldfacture = factureRepo.findById(num_facture).orElseThrow();
		
		oldfacture.setNom(newdto.getNom());
		oldfacture.setMontant(newdto.getMontant());
		oldfacture.setDate_facture(newdto.getDate_facture());
		oldfacture.setUser(user);
		
		return factureRepo.save(oldfacture);
	}
	
	@Transactional
	public void deleteFacture(int num_facture) {
		
		sessionManager.setCurrentUserInDB();
		
		Facture facture = factureRepo.findById(num_facture).orElseThrow();
		
		factureRepo.delete(facture);
	}
	
	@Transactional
	public List<FactureDto> getAllFacture() {
		List<FactureDto> allDto = new ArrayList<FactureDto>();
		List<Facture> allFacture = this.factureRepo.findAll(Sort.by("numFacture").ascending());
		
		for (Facture f : allFacture) {
			FactureDto dto = new FactureDto();
			
			dto.setId_facture(f.getNum_facture());
			dto.setNom(f.getNom());
			dto.setDate_facture(f.getDate_facture());
			dto.setMontant(f.getMontant());
			
			allDto.add(dto);
		}
		
		return allDto;
	}
	
}
