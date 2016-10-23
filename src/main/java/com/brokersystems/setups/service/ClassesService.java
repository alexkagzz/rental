package com.brokersystems.setups.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.AccountTypes;
import com.brokersystems.setups.model.BinderDetails;
import com.brokersystems.setups.model.BindersDef;
import com.brokersystems.setups.model.ClassesDef;
import com.brokersystems.setups.model.ClausesDef;
import com.brokersystems.setups.model.CoverTypesDef;
import com.brokersystems.setups.model.PremRatesDef;
import com.brokersystems.setups.model.ProductGroupDef;
import com.brokersystems.setups.model.ProductSubclasses;
import com.brokersystems.setups.model.ProductsDef;
import com.brokersystems.setups.model.SectionsDef;
import com.brokersystems.setups.model.SubClassDef;

public interface ClassesService {
	
	DataTablesResult<ClassesDef> findAllClasses(DataTablesRequest request)  throws IllegalAccessException;
	
	void createClass(ClassesDef classDef);
	
	DataTablesResult<SubClassDef> findAllSubclass(DataTablesRequest request,Long classId)  throws IllegalAccessException;
	
	void createSubClass(SubClassDef subclassDef);
	
	DataTablesResult<CoverTypesDef> findAllCOverTypes(DataTablesRequest request,Long subId)  throws IllegalAccessException;
	
	void createCoverType(CoverTypesDef coverType);
	
	DataTablesResult<SectionsDef> findCoverTypeSections(DataTablesRequest request,Long coverId)  throws IllegalAccessException;
	
	void createSection(SectionsDef section);
	
	DataTablesResult<ClausesDef> findAllClauses(DataTablesRequest request,Long subCode)  throws IllegalAccessException;
	
	void createClause(ClausesDef section);
	
	public Page<ProductGroupDef> findProductGroupforSel(String paramString, Pageable paramPageable);
	
	void createProductGroup(ProductGroupDef group);
	
	DataTablesResult<ProductsDef> findAllProducts(DataTablesRequest request,Long prgCode)  throws IllegalAccessException;
	
	void createProduct(ProductsDef product);
	
	DataTablesResult<ProductSubclasses> findProdSubClass(DataTablesRequest request,Long prodCode)  throws IllegalAccessException;
	
	public Page<ProductsDef> findProductsSel(String paramString, Pageable paramPageable);
	
	public Page<AccountDef> findInsuranceAccounts(String paramString, Pageable paramPageable);
	
	DataTablesResult<BindersDef> findInsuranceBinders(DataTablesRequest request,Long accCode)  throws IllegalAccessException;
	
	void createBinder(BindersDef binder) throws BadRequestException;
	
	DataTablesResult<BinderDetails> findBinderDetails(DataTablesRequest request,Long bindCode)  throws IllegalAccessException;
	
	void createBinderDetails(BinderDetails det) throws BadRequestException;
	
	public Page<ProductSubclasses> findProdSubclassSel(String paramString, Pageable paramPageable,Long prodCode);
	
	public Page<CoverTypesDef> findCoverTypesSel(String paramString, Pageable paramPageable,Long subCode);
	
	DataTablesResult<PremRatesDef> findDetPremRates(DataTablesRequest request,Long detCode)  throws IllegalAccessException;
	
	void createPremRates(PremRatesDef rates) throws BadRequestException;
	
	public Page<SectionsDef> findSectionSel(String paramString, Pageable paramPageable,Long covCode);

}
