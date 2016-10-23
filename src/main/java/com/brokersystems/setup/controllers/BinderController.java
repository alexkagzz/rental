package com.brokersystems.setup.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brokersystems.server.datatables.DataTable;
import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.BinderDetails;
import com.brokersystems.setups.model.BindersDef;
import com.brokersystems.setups.model.ClassesDef;
import com.brokersystems.setups.model.CoverTypesDef;
import com.brokersystems.setups.model.PremRatesDef;
import com.brokersystems.setups.model.ProductGroupDef;
import com.brokersystems.setups.model.ProductSubclasses;
import com.brokersystems.setups.model.ProductsDef;
import com.brokersystems.setups.model.SectionsDef;
import com.brokersystems.setups.model.SubClassDef;
import com.brokersystems.setups.service.ClassesService;

@Controller
@RequestMapping({ "/protected/setups/binders" })
public class BinderController {
	
	@Autowired
	private ClassesService service;
	
	@RequestMapping(value = "bindersHome",method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public String classHome(Model model)
	  {
	    return "bindershome";
	  }
	
	@RequestMapping(value = { "selproducts" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<ProductsDef> selProducts(@RequestParam(value = "term", required = false) String term, Pageable pageable)
			throws IllegalAccessException {
		return service.findProductsSel(term, pageable);
	}
	
	@RequestMapping(value = { "selAccounts" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<AccountDef> selAccounts(@RequestParam(value = "term", required = false) String term, Pageable pageable)
			throws IllegalAccessException {
		return service.findInsuranceAccounts(term, pageable);
	}
	
	@RequestMapping(value = { "selSubclass" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<ProductSubclasses> selSubclass(@RequestParam(value = "term", required = false) String term, Pageable pageable,@RequestParam("proCode")Long proCode)
			throws IllegalAccessException {
		return service.findProdSubclassSel(term, pageable,proCode);
	}
	
	@RequestMapping(value = { "selCoverTypes" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<CoverTypesDef> selCoverTypes(@RequestParam(value = "term", required = false) String term, Pageable pageable,@RequestParam("subCode")Long subCode)
			throws IllegalAccessException {
		return service.findCoverTypesSel(term, pageable, subCode);
	}
	
	
	@RequestMapping(value = { "selSections" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<SectionsDef> selSections(@RequestParam(value = "term", required = false) String term, Pageable pageable,@RequestParam("covCode")Long covCode)
			throws IllegalAccessException {
		return service.findSectionSel(term, pageable, covCode);
	}
	
	@RequestMapping(value = { "binders/{accCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<BindersDef> getBinders(@DataTable DataTablesRequest pageable,@PathVariable Long accCode)
			throws IllegalAccessException {
		return service.findInsuranceBinders(pageable,accCode);
	}
	
	@RequestMapping(value = { "createBinder" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createBinder(BindersDef binder) throws IllegalAccessException, IOException, BadRequestException {
		service.createBinder(binder);
	}
	
	@RequestMapping(value = { "binderdetails/{binCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<BinderDetails> getBinderDetails(@DataTable DataTablesRequest pageable,@PathVariable Long binCode)
			throws IllegalAccessException {
		return service.findBinderDetails(pageable,binCode);
	}
	
	@RequestMapping(value = { "createBinderDet" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createBinderDet(BinderDetails det) throws IllegalAccessException, IOException, BadRequestException {
		service.createBinderDetails(det);
	}
	
	@RequestMapping(value = { "premrates/{detCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<PremRatesDef> getPremRates(@DataTable DataTablesRequest pageable,@PathVariable Long detCode)
			throws IllegalAccessException {
		return service.findDetPremRates(pageable, detCode);
	}
	
	@RequestMapping(value = { "createPremRates" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createPremRates(PremRatesDef rates) throws IllegalAccessException, IOException, BadRequestException {
		service.createPremRates(rates);
	}


}
