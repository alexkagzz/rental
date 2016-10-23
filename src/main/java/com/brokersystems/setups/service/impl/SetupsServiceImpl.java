package com.brokersystems.setups.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.action.internal.QueuedOperationCollectionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setup.repository.AccountRepo;
import com.brokersystems.setup.repository.AccountTypeRepo;
import com.brokersystems.setup.repository.CountryRepository;
import com.brokersystems.setup.repository.CountyRepository;
import com.brokersystems.setup.repository.CurrencyRepository;
import com.brokersystems.setup.repository.OrgBranchRepository;
import com.brokersystems.setup.repository.PaymentModeRepo;
import com.brokersystems.setup.repository.SequenceRepository;
import com.brokersystems.setup.repository.ClientRepository;
import com.brokersystems.setup.repository.TownRepository;
import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.AccountTypes;
import com.brokersystems.setups.model.Country;
import com.brokersystems.setups.model.County;
import com.brokersystems.setups.model.Currencies;
import com.brokersystems.setups.model.OrgBranch;
import com.brokersystems.setups.model.OrgRegions;
import com.brokersystems.setups.model.PaymentModes;
import com.brokersystems.setups.model.QAccountDef;
import com.brokersystems.setups.model.QAccountTypes;
import com.brokersystems.setups.model.QCountry;
import com.brokersystems.setups.model.QCounty;
import com.brokersystems.setups.model.QCurrencies;
import com.brokersystems.setups.model.QOrgBranch;
import com.brokersystems.setups.model.QOrgRegions;
import com.brokersystems.setups.model.QPaymentModes;
import com.brokersystems.setups.model.QSystemSequence;
import com.brokersystems.setups.model.QTown;
import com.brokersystems.setups.model.SystemSequence;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.Town;
import com.brokersystems.setups.service.SetupsService;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class SetupsServiceImpl implements SetupsService {

	@Autowired
	private CurrencyRepository currRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private CountyRepository countyRepo;

	@Autowired
	private TownRepository townRepo;


	@Autowired
	private OrgBranchRepository branchRepo;


	@Autowired
	private PaymentModeRepo payRepo;

	@Autowired
	private AccountTypeRepo acctypeRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private ClientRepository clientRepo;


	@Autowired
	private SequenceRepository sequenceRepo;

	@Override
	@Transactional(readOnly = true)
	public DataTablesResult<Currencies> findAllCurrencies(DataTablesRequest request) throws IllegalAccessException {
		Page<Currencies> page = currRepo.findAll(request.searchPredicate(QCurrencies.currencies), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Transactional(readOnly = true)
	public DataTablesResult<SystemSequence> findAllSequences(DataTablesRequest request) throws IllegalAccessException {
		Page<SystemSequence> page = sequenceRepo.findAll(request.searchPredicate(QSystemSequence.systemSequence),
				request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCurrency(Currencies currency) {

		currRepo.save(currency);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCurrency(Long currCode) {
		currRepo.delete(currCode);

	}

	@Override
	public DataTablesResult<Country> findAllCountries(DataTablesRequest request) throws IllegalAccessException {
		Page<Country> page = countryRepo.findAll(request.searchPredicate(QCountry.country), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCountry(Country country) {
		countryRepo.save(country);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCountry(Long couCode) {
		countryRepo.delete(couCode);

	}

	@Override
	public DataTablesResult<County> findCountiesByCountry(long couCode, DataTablesRequest request)
			throws IllegalAccessException {
		QCountry country = QCounty.county.country;
		BooleanExpression pred = country.couCode.eq(couCode);
		Page<County> page = countyRepo.findAll(pred.and(request.searchPredicate(QCounty.county)), request);
		return new DataTablesResult(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCounty(County county) {
		countyRepo.save(county);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCounty(Long countyCode) {
		countyRepo.delete(countyCode);

	}

	@Override
	public DataTablesResult<Town> findTownsByCounty(long countyCode, DataTablesRequest request)
			throws IllegalAccessException {
		QCounty county = QTown.town.county;
		BooleanExpression pred = county.countyId.eq(countyCode);
		Page<Town> page = townRepo.findAll(pred.and(request.searchPredicate(QTown.town)), request);
		return new DataTablesResult(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineTown(Town town) {
		townRepo.save(town);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteTown(Long townCode) {
		townRepo.delete(townCode);
	}

	
	@Override
	public Page<OrgBranch> findBranchForSelect(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QOrgBranch.orgBranch.isNotNull();
		} else {
			pred = QOrgBranch.orgBranch.obName.containsIgnoreCase(paramString);
		}
		return branchRepo.findAll(pred, paramPageable);
	}

	
	

	

	@Override
	public DataTablesResult<PaymentModes> findAllPaymentModes(DataTablesRequest request) throws IllegalAccessException {
		Page<PaymentModes> page = payRepo.findAll(request.searchPredicate(QPaymentModes.paymentModes), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void definePaymentMode(PaymentModes mode) throws BadRequestException {
		if (mode.getPmMaxValue().compareTo(mode.getPmMinValue()) == -1) {
			throw new BadRequestException("Max Value cannot be less than min Value");
		}
		payRepo.save(mode);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deletePaymentMode(Long pmId) {
		payRepo.delete(pmId);

	}

	@Override
	public DataTablesResult<AccountTypes> findAllAccountTypes(DataTablesRequest request) throws IllegalAccessException {
		Page<AccountTypes> page = acctypeRepo.findAll(request.searchPredicate(QAccountTypes.accountTypes), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineAccountType(AccountTypes acctypes) throws BadRequestException {
		if (acctypes.isVatAppli()) {
			if (acctypes.getVatRate() == null || acctypes.getVatRate().compareTo(BigDecimal.ZERO) <= 0) {
				throw new BadRequestException("Vat Rate cannot be zero or less than zero if Vat is applicable");
			}
			if (acctypes.getVatRate().compareTo(new BigDecimal(100)) == 1) {
				throw new BadRequestException("VAT Rate cannot cannot be greater than 100");
			}
		}
		if (acctypes.isWhtxAppl()) {
			if (acctypes.getWhtaxVal() == null || acctypes.getWhtaxVal().compareTo(BigDecimal.ZERO) <= 0) {
				throw new BadRequestException("Whtx Rate cannot be zero or less than zero if Whtx is applicable");
			}
			if (acctypes.getWhtaxVal().compareTo(new BigDecimal(100)) == 1) {
				throw new BadRequestException("Whtx Rate cannot cannot be greater than 100");
			}
		}
		acctypeRepo.save(acctypes);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteAccountType(Long acctId) {
		acctypeRepo.delete(acctId);
	}

	@Override
	public Page<AccountTypes> findAccountTypesforSelect(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QAccountTypes.accountTypes.isNotNull();
		} else {
			pred = QAccountTypes.accountTypes.accShtDesc.containsIgnoreCase(paramString);
		}
		return acctypeRepo.findAll(pred, paramPageable);
	}

	@Override
	public DataTablesResult<AccountDef> findAllAccounts(long accId, DataTablesRequest request)
			throws IllegalAccessException {
		QAccountTypes accountType = QAccountDef.accountDef.accountType;
		BooleanExpression pred = accountType.accId.eq(accId);
		Page<AccountDef> page = accountRepo.findAll(pred.and(request.searchPredicate(QAccountDef.accountDef)), request);
		return new DataTablesResult(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public AccountDef getAccountDetails(Long acctId) {
		return accountRepo.findOne(acctId);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineAccount(AccountDef account) throws BadRequestException {
		if (account.getAccountType() == null) {
			throw new BadRequestException("Select Account Type to continue...");
		}

		if (account.getAccountType() == null) {
			throw new BadRequestException("Select Account Branch to continue...");
		}

		if (account.getDob() != null) {
			Date today = new Date();
			if (today.before(account.getDob())) {
				throw new BadRequestException("Date of Birth/Date of Incorporation cannot be greater than today");
			}
		}
		if (null == account.getStatus() || "".equals(account.getStatus())) {
			if (account.getAcctId() != null) {
				throw new BadRequestException("Select Status...");
			} else {
				account.setStatus("A");
			}
		}
		accountRepo.save(account);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteAccount(Long acctId) {
		accountRepo.delete(acctId);

	}



	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineSequence(SystemSequence sequence) throws BadRequestException {
		Predicate pred = QSystemSequence.systemSequence.transType.eq(sequence.getTransType());
		if(sequence.getSeqId()==null)
		if (sequenceRepo.count(pred) > 0) {
			throw new BadRequestException("The Sequence for the transaction already exists..");
		}
		sequenceRepo.save(sequence);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteSequence(Long seqCode) {
		sequenceRepo.delete(seqCode);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineClient(ClientDef client) throws BadRequestException {
		Predicate seqPredicate = QSystemSequence.systemSequence.transType.eq("C");
		if (sequenceRepo.count(seqPredicate) == 0)
			throw new BadRequestException("Sequence for Client Definition has not been setup");
		SystemSequence sequence = sequenceRepo.findOne(seqPredicate);
		Long seqNumber = sequence.getNextNumber();
		final String clientNumber = sequence.getSeqPrefix() + String.format("%06d", seqNumber);
		sequence.setLastNumber(seqNumber);
		sequence.setNextNumber(seqNumber + 1);
		sequenceRepo.save(sequence);
		client.setTenantNumber(clientNumber);
		clientRepo.save(client);
	}

	@Override
	public ClientDef getClientDetails(Long tenId) {
		 return clientRepo.findOne(tenId);
	}


}
