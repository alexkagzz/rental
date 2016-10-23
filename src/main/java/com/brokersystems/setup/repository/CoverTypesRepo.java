package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.CoverTypesDef;

public interface CoverTypesRepo  extends  PagingAndSortingRepository<CoverTypesDef, Long>, QueryDslPredicateExecutor<CoverTypesDef> {

}
