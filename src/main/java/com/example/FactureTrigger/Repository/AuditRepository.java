package com.example.FactureTrigger.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FactureTrigger.Model.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer>{

	List<Audit> findAllByOrderByActionTimestampDesc();
}
