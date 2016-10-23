package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.SectionsDef;

public interface SectionRepo extends  PagingAndSortingRepository<SectionsDef, Long>, QueryDslPredicateExecutor<SectionsDef> {

}
