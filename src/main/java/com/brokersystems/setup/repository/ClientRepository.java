package com.brokersystems.setup.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.ClientDef;

public interface ClientRepository extends  PagingAndSortingRepository<ClientDef, Long>, QueryDslPredicateExecutor<ClientDef> {

	Optional<ClientDef> findByTenId(Long tenId);
	
	
	
	
}
