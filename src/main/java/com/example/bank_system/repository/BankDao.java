package com.example.bank_system.repository;


import java.util.Optional;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank_system.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String> {
	

	Optional<Bank> findById(String card);
	

	public List<Bank> findByCard(String card);
	
}
