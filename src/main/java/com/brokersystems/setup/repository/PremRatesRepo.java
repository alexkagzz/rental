package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.PremRatesDef;

public interface PremRatesRepo extends  PagingAndSortingRepository<PremRatesDef, Long>, QueryDslPredicateExecutor<PremRatesDef> {

}
