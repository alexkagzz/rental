package com.brokersystems.transactions.uw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brokersystems.server.datatables.DataTable;
import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.transactions.uw.model.PolicyTrans;
import com.brokersystems.transactions.uw.service.PolicyTransService;

@Controller
@RequestMapping(value = "/protected/home/policies")
public class PolicyTransController {
	
	@Autowired
	private PolicyTransService polService;
	
	@RequestMapping(value = "newbusiness",method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public String classHome(Model model)
	  {
	    return "newbusiness";
	  }
	
	@RequestMapping(value = { "policies" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<PolicyTrans> getPolicies(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return polService.findAllPolicies(pageable);
	}

}
