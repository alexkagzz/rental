package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.ProductsDef;

public interface ProductsRepo extends  PagingAndSortingRepository<ProductsDef, Long>, QueryDslPredicateExecutor<ProductsDef> {

}
