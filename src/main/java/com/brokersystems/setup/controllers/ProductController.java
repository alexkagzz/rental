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
import com.brokersystems.setups.model.ProductGroupDef;
import com.brokersystems.setups.model.ProductSubclasses;
import com.brokersystems.setups.model.ProductsDef;
import com.brokersystems.setups.model.SubClassDef;
import com.brokersystems.setups.service.ClassesService;

@Controller
@RequestMapping({ "/protected/setups/products" })
public class ProductController {
	
	@Autowired
	private ClassesService service;
	
	@RequestMapping(value = "productsHome",method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public String classHome(Model model)
	  {
	    return "productsform";
	  }
	
	@RequestMapping(value = { "selprodgroups" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public Page<ProductGroupDef> selProdGroups(@RequestParam(value = "term", required = false) String term, Pageable pageable)
			throws IllegalAccessException {
		return service.findProductGroupforSel(term, pageable);
	}
	
	@RequestMapping(value = { "createGroup" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createClass(ProductGroupDef group) throws IllegalAccessException, IOException, BadRequestException {
		service.createProductGroup(group);
	}
	
	
	@RequestMapping(value = { "products/{prodCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ProductsDef> getProducts(@DataTable DataTablesRequest pageable,@PathVariable Long prodCode)
			throws IllegalAccessException {
		return service.findAllProducts(pageable,prodCode);
	}
	
	@RequestMapping(value = { "createProduct" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createProduct(ProductsDef product) throws IllegalAccessException, IOException, BadRequestException {
		service.createProduct(product);
	}
	
	@RequestMapping(value = { "subclasses/{prodCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ProductSubclasses> getProductSubclasses(@DataTable DataTablesRequest pageable,@PathVariable Long prodCode)
			throws IllegalAccessException {
		return service.findProdSubClass(pageable, prodCode);
	}
	

}
