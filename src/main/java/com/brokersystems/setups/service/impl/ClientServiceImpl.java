package com.brokersystems.setups.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.setup.repository.ClientRepository;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.QClientDef;
import com.brokersystems.setups.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	@Transactional(readOnly = true)
	public DataTablesResult<ClientDef> findAllClients(DataTablesRequest request) throws IllegalAccessException {
		Page<ClientDef> page = clientRepo.findAll(request.searchPredicate(QClientDef.clientDef), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
    @Transactional(readOnly=false)
	public void defineClient(ClientDef tenant) {
		clientRepo.save(tenant);
		
	}

	@Override
	@Modifying
    @Transactional(readOnly=false)
	public void deleteClient(Long tenId) {
		clientRepo.delete(tenId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public ClientDef getClientDetails(Long tenId) {
		return clientRepo.findByTenId(tenId).orElse(new ClientDef());
	}

}
