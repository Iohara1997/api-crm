package com.api.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
