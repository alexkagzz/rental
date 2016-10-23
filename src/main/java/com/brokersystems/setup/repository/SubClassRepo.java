package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.SubClassDef;

public interface SubClassRepo extends  PagingAndSortingRepository<SubClassDef, Long>, QueryDslPredicateExecutor<SubClassDef> {

}
