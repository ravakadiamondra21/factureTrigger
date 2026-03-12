package com.example.FactureTrigger.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FactureTrigger.Dto.CountingAuditDto;
import com.example.FactureTrigger.Model.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer>{

	List<Audit> findAllByOrderByActionTimestampDesc();
	
	@Query("""
			SELECT new com.example.FactureTrigger.Dto.CountingAuditDto(a.action_type, COUNT(a))
			FROM Audit a
			GROUP BY a.action_type
			""")
	List<CountingAuditDto> countActions();
}
