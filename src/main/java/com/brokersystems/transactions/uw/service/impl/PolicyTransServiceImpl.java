package com.brokersystems.transactions.uw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.transactions.uw.model.PolicyTrans;
import com.brokersystems.transactions.uw.model.QPolicyTrans;
import com.brokersystems.transactions.uw.repo.PolicyTransRepo;
import com.brokersystems.transactions.uw.service.PolicyTransService;

@Service
public class PolicyTransServiceImpl implements PolicyTransService {
	
	@Autowired
	private PolicyTransRepo policyRepo;

	@Override
	public DataTablesResult<PolicyTrans> findAllPolicies(DataTablesRequest request) throws IllegalAccessException {
		Page<PolicyTrans> page = policyRepo.findAll(request.searchPredicate(QPolicyTrans.policyTrans), request);
		return new DataTablesResult<>(request, page);
	}

}
