package com.brokersystems.setups.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setup.repository.AccountRepo;
import com.brokersystems.setup.repository.BinderDetRepo;
import com.brokersystems.setup.repository.BindersRepo;
import com.brokersystems.setup.repository.ClassesRepo;
import com.brokersystems.setup.repository.ClausesRepo;
import com.brokersystems.setup.repository.CoverTypesRepo;
import com.brokersystems.setup.repository.PremRatesRepo;
import com.brokersystems.setup.repository.ProdSubclassRepo;
import com.brokersystems.setup.repository.ProductGroupRepo;
import com.brokersystems.setup.repository.ProductsRepo;
import com.brokersystems.setup.repository.SectionRepo;
import com.brokersystems.setup.repository.SubClassRepo;
import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.BinderDetails;
import com.brokersystems.setups.model.BindersDef;
import com.brokersystems.setups.model.ClassesDef;
import com.brokersystems.setups.model.ClausesDef;
import com.brokersystems.setups.model.CoverTypesDef;
import com.brokersystems.setups.model.PremRatesDef;
import com.brokersystems.setups.model.ProductGroupDef;
import com.brokersystems.setups.model.ProductSubclasses;
import com.brokersystems.setups.model.ProductsDef;
import com.brokersystems.setups.model.QAccountDef;
import com.brokersystems.setups.model.QAccountTypes;
import com.brokersystems.setups.model.QBinderDetails;
import com.brokersystems.setups.model.QBindersDef;
import com.brokersystems.setups.model.QClassesDef;
import com.brokersystems.setups.model.QClausesDef;
import com.brokersystems.setups.model.QCounty;
import com.brokersystems.setups.model.QCoverTypesDef;
import com.brokersystems.setups.model.QPremRatesDef;
import com.brokersystems.setups.model.QProductGroupDef;
import com.brokersystems.setups.model.QProductSubclasses;
import com.brokersystems.setups.model.QProductsDef;
import com.brokersystems.setups.model.QSectionsDef;
import com.brokersystems.setups.model.QSubClassDef;
import com.brokersystems.setups.model.SectionsDef;
import com.brokersystems.setups.model.SubClassDef;
import com.brokersystems.setups.service.ClassesService;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class ClassesServiceImpl implements ClassesService {
	
	@Autowired
	private ClassesRepo classRepo;
	
	@Autowired
	private SubClassRepo subclassRepo;
	
	@Autowired
	private CoverTypesRepo coverRepo;
	
	@Autowired
	private SectionRepo sectionRepo;
	
	@Autowired
	private ClausesRepo clauseRepo;
	
	@Autowired
	private ProductGroupRepo groupRepo;
	
	@Autowired
	private ProductsRepo prodRepo;
	
	@Autowired
	private ProdSubclassRepo prodSubRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private BindersRepo binderRepo;
	
	@Autowired
	private BinderDetRepo binderDetRepo;
	
	@Autowired
	private PremRatesRepo premRepo;

	@Override
	public DataTablesResult<ClassesDef> findAllClasses(DataTablesRequest request) throws IllegalAccessException {
		Page<ClassesDef> page = classRepo.findAll(request.searchPredicate(QClassesDef.classesDef), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createClass(ClassesDef classDef) {
		classRepo.save(classDef);
	}

	@Override
	public DataTablesResult<SubClassDef> findAllSubclass(DataTablesRequest request, Long classId)
			throws IllegalAccessException {
		BooleanExpression pred = QSubClassDef.subClassDef.classDef.clId.eq(classId);
		Page<SubClassDef> page = subclassRepo.findAll(pred.and(request.searchPredicate(QSubClassDef.subClassDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createSubClass(SubClassDef subclassDef) {
		subclassRepo.save(subclassDef);
	}

	@Override
	public DataTablesResult<CoverTypesDef> findAllCOverTypes(DataTablesRequest request, Long subId)
			throws IllegalAccessException {
		BooleanExpression pred = QCoverTypesDef.coverTypesDef.subclass.subId.eq(subId);
		Page<CoverTypesDef> page = coverRepo.findAll(pred.and(request.searchPredicate(QCoverTypesDef.coverTypesDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createCoverType(CoverTypesDef coverType) {
		coverRepo.save(coverType);
	}

	@Override
	public DataTablesResult<SectionsDef> findCoverTypeSections(DataTablesRequest request, Long coverId)
			throws IllegalAccessException {
		BooleanExpression pred = QSectionsDef.sectionsDef.coverType.covId.eq(coverId);
	    Page<SectionsDef> page = sectionRepo.findAll(pred.and(request.searchPredicate(QSectionsDef.sectionsDef)), request);
	    return new DataTablesResult<>(request, page);
	}

	@Override
	public void createSection(SectionsDef section) {
		sectionRepo.save(section);
	}

	@Override
	public DataTablesResult<ClausesDef> findAllClauses(DataTablesRequest request, Long subCode)
			throws IllegalAccessException {
		BooleanExpression pred = QClausesDef.clausesDef.subclass.subId.eq(subCode);
		Page<ClausesDef> page = clauseRepo.findAll(pred.and(request.searchPredicate(QClausesDef.clausesDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createClause(ClausesDef clause) {
		clauseRepo.save(clause);
	}

	@Override
	public Page<ProductGroupDef> findProductGroupforSel(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QProductGroupDef.productGroupDef.isNotNull();
		} else {
			pred = QProductGroupDef.productGroupDef.prgDesc.containsIgnoreCase(paramString);
		}
		return groupRepo.findAll(pred, paramPageable);
	}

	@Override
	public void createProductGroup(ProductGroupDef group) {
		groupRepo.save(group);
	}

	@Override
	public DataTablesResult<ProductsDef> findAllProducts(DataTablesRequest request, Long prgCode)
			throws IllegalAccessException {
		BooleanExpression pred = QProductsDef.productsDef.proGroup.prgCode.eq(prgCode);
		Page<ProductsDef> page = prodRepo.findAll(pred.and(request.searchPredicate(QProductsDef.productsDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createProduct(ProductsDef product) {
		prodRepo.save(product);
	}

	@Override
	public DataTablesResult<ProductSubclasses> findProdSubClass(DataTablesRequest request, Long prodCode)
			throws IllegalAccessException {
		BooleanExpression pred = QProductSubclasses.productSubclasses.product.proCode.eq(prodCode);
		Page<ProductSubclasses> page = prodSubRepo.findAll(pred.and(request.searchPredicate(QProductSubclasses.productSubclasses)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public Page<ProductsDef> findProductsSel(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QProductsDef.productsDef.isNotNull();
		} else {
			pred = QProductsDef.productsDef.proDesc.containsIgnoreCase(paramString).or(QProductsDef.productsDef.proShtDesc.containsIgnoreCase(paramString));
		}
		return prodRepo.findAll(pred, paramPageable);
	}

	@Override
	public Page<AccountDef> findInsuranceAccounts(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QAccountDef.accountDef.isNotNull();
		} else {
			pred =  QAccountDef.accountDef.name.containsIgnoreCase(paramString);
		}
		return accountRepo.findAll(pred, paramPageable);
	}
	
	@Override
	public Page<ProductSubclasses> findProdSubclassSel(String paramString, Pageable paramPageable,Long prodCode) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QProductSubclasses.productSubclasses.product.proCode.eq(prodCode).and(QProductSubclasses.productSubclasses.isNotNull());
		} else {
			pred =  QProductSubclasses.productSubclasses.product.proCode.eq(prodCode).and(QProductSubclasses.productSubclasses.subclass.subDesc.containsIgnoreCase(paramString));
		}
		return prodSubRepo.findAll(pred, paramPageable);
	}

	@Override
	public DataTablesResult<BindersDef> findInsuranceBinders(DataTablesRequest request, Long accCode)
			throws IllegalAccessException {
		BooleanExpression pred = QBindersDef.bindersDef.account.acctId.eq(accCode);
		Page<BindersDef> page = binderRepo.findAll(pred.and(request.searchPredicate(QBindersDef.bindersDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createBinder(BindersDef binder) throws BadRequestException {
		binderRepo.save(binder);
	}

	@Override
	public DataTablesResult<BinderDetails> findBinderDetails(DataTablesRequest request, Long bindCode)
			throws IllegalAccessException {
		BooleanExpression pred = QBinderDetails.binderDetails.binder.binId.eq(bindCode);
		Page<BinderDetails> page = binderDetRepo.findAll(pred.and(request.searchPredicate(QBinderDetails.binderDetails)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createBinderDetails(BinderDetails det) throws BadRequestException {
		binderDetRepo.save(det);
	}

	@Override
	public Page<CoverTypesDef> findCoverTypesSel(String paramString, Pageable paramPageable, Long subCode) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QCoverTypesDef.coverTypesDef.subclass.subId.eq(subCode).and(QCoverTypesDef.coverTypesDef.isNotNull());
		} else {
			pred =  QCoverTypesDef.coverTypesDef.subclass.subId.eq(subCode).and(QCoverTypesDef.coverTypesDef.covName.containsIgnoreCase(paramString));
		}
		return coverRepo.findAll(pred, paramPageable);
	}

	@Override
	public DataTablesResult<PremRatesDef> findDetPremRates(DataTablesRequest request, Long detCode)
			throws IllegalAccessException {
		BooleanExpression pred = QPremRatesDef.premRatesDef.binderDet.detId.eq(detCode);
		Page<PremRatesDef> page = premRepo.findAll(pred.and(request.searchPredicate(QPremRatesDef.premRatesDef)), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void createPremRates(PremRatesDef rates) throws BadRequestException {
		premRepo.save(rates);
	}

	@Override
	public Page<SectionsDef> findSectionSel(String paramString, Pageable paramPageable, Long covCode) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred =  QSectionsDef.sectionsDef.coverType.covId.eq(covCode).and(QSectionsDef.sectionsDef.isNotNull());
		} else {
			pred =  QSectionsDef.sectionsDef.coverType.covId.eq(covCode).and(QSectionsDef.sectionsDef.desc.containsIgnoreCase(paramString));
		}
		return sectionRepo.findAll(pred, paramPageable);
	}

	

}
