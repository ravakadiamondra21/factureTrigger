package com.example.FactureTrigger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FactureTrigger.Model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer>{

}
