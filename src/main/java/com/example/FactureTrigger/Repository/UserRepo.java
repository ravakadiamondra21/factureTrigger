package com.example.FactureTrigger.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FactureTrigger.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User> findByUserEmail(String email);
}
