package com.brokersystems.transactions.uw.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brokersystems.transactions.uw.model.SectionTrans;

public interface SectionTransRepo extends  PagingAndSortingRepository<SectionTrans, Long>, QueryDslPredicateExecutor<SectionTrans> {

}
