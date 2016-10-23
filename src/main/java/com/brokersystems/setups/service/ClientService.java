package com.brokersystems.setups.service;

import java.util.Optional;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.setups.model.ClientDef;

/**
 * Tenant Service
 * Used for crud services for tenant operations
 * @author Peter
 *
 */
public interface ClientService {
	
	
	DataTablesResult<ClientDef> findAllClients(DataTablesRequest request)  throws IllegalAccessException;
	
    void defineClient(ClientDef tenant);
	
	void deleteClient(Long tenId);
	
	ClientDef getClientDetails(Long tenId);

}
