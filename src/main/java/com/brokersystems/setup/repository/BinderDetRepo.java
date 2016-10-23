package com.brokersystems.setup.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.setups.model.BinderDetails;


public interface BinderDetRepo extends  PagingAndSortingRepository<BinderDetails, Long>, QueryDslPredicateExecutor<BinderDetails> {

}
