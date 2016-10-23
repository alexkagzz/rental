package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.ClassesDef;

public interface ClassesRepo extends  PagingAndSortingRepository<ClassesDef, Long>, QueryDslPredicateExecutor<ClassesDef> {

}
