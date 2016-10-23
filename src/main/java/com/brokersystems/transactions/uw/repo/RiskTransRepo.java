package com.brokersystems.transactions.uw.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.transactions.uw.model.RiskTrans;

public interface RiskTransRepo  extends  PagingAndSortingRepository<RiskTrans, Long>, QueryDslPredicateExecutor<RiskTrans>{

}
