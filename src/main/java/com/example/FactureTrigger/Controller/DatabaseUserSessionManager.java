package com.example.FactureTrigger.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.FactureTrigger.Model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DatabaseUserSessionManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void setCurrentUserInDB() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null && auth.isAuthenticated()) {
			Object principal = auth.getPrincipal();
			
			if (principal instanceof User) {
				String name = ((User) principal).getUserName();
				
				entityManager.createNativeQuery("SELECT set_config('app.current_user', :userName, true)")
							.setParameter("userName", name)
							.getSingleResult();
			}
		}
	}
}
