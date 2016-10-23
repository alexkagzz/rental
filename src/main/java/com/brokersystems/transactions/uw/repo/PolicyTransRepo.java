package com.brokersystems.transactions.uw.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.transactions.uw.model.PolicyTrans;

public interface PolicyTransRepo extends  PagingAndSortingRepository<PolicyTrans, Long>, QueryDslPredicateExecutor<PolicyTrans>{

}
