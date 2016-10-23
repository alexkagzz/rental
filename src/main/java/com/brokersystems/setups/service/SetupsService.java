package com.brokersystems.setups.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.AccountTypes;
import com.brokersystems.setups.model.Country;
import com.brokersystems.setups.model.County;
import com.brokersystems.setups.model.Currencies;
import com.brokersystems.setups.model.OrgBranch;
import com.brokersystems.setups.model.PaymentModes;
import com.brokersystems.setups.model.SystemSequence;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.Town;
import com.mysema.query.types.Predicate;

/**
 * This  is used to maintain crud and query services of several setups screens
 * in the system like Currency, Countries, Counties, Citys
 * @author mugenyq
 *
 */
public interface SetupsService {
	
	public DataTablesResult<SystemSequence> findAllSequences(DataTablesRequest request) throws IllegalAccessException;
	
	public void defineSequence(SystemSequence sequence) throws BadRequestException;
	
	void deleteSequence(Long seqCode);
	
	DataTablesResult<Currencies> findAllCurrencies(DataTablesRequest request)  throws IllegalAccessException;
	
	void defineCurrency(Currencies currency);
	
	void deleteCurrency(Long currCode);
	
	DataTablesResult<Country> findAllCountries(DataTablesRequest request)  throws IllegalAccessException;
	
	void defineCountry(Country country);
	
	void deleteCountry(Long couCode);
	
	DataTablesResult<County> findCountiesByCountry(long couCode,DataTablesRequest request)  throws IllegalAccessException;
	
    void defineCounty(County county);
	
	void deleteCounty(Long countyCode);
	
    DataTablesResult<Town> findTownsByCounty(long countyCode,DataTablesRequest request)  throws IllegalAccessException;
	
    void defineTown(Town town);
	
	void deleteTown(Long townCode);
	
	 Page<OrgBranch> findBranchForSelect(String paramString, Pageable paramPageable);
     
     DataTablesResult<PaymentModes> findAllPaymentModes(DataTablesRequest request)  throws IllegalAccessException;
 	
     void definePaymentMode(PaymentModes mode) throws BadRequestException;
 	
 	 void deletePaymentMode(Long pmId);
 	
 	 DataTablesResult<AccountTypes> findAllAccountTypes(DataTablesRequest request)  throws IllegalAccessException;
 	 
 	void defineAccountType(AccountTypes accType) throws BadRequestException;
 	
	void deleteAccountType(Long acctId);
	
	public Page<AccountTypes> findAccountTypesforSelect(String paramString, Pageable paramPageable);
	
	DataTablesResult<AccountDef> findAllAccounts(long accId,DataTablesRequest request)  throws IllegalAccessException;

    AccountDef getAccountDetails(Long acctId);	
    
    void defineAccount(AccountDef account) throws BadRequestException;
    
    void deleteAccount(Long acctId);
    
    
    void defineClient(ClientDef tenant) throws BadRequestException;
    
    ClientDef getClientDetails(Long tenId);
    
    
    
	
}
