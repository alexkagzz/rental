package com.brokersystems.transactions.uw.service;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.transactions.uw.model.PolicyTrans;

public interface PolicyTransService {
	
	public DataTablesResult<PolicyTrans> findAllPolicies(DataTablesRequest request)
			throws IllegalAccessException;

}
