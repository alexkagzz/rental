package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.ProductSubclasses;

public interface ProdSubclassRepo extends  PagingAndSortingRepository<ProductSubclasses, Long>, QueryDslPredicateExecutor<ProductSubclasses> {

}
