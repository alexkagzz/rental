package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.ClausesDef;

public interface ClausesRepo extends  PagingAndSortingRepository<ClausesDef, Long>, QueryDslPredicateExecutor<ClausesDef> {

}
