package com.brokersystems.setup.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.brokersystems.setups.model.ModelHelperForm;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.service.SetupsService;
import com.brokersystems.setups.service.ClientService;

@Controller
@RequestMapping({ "/protected/clients/setups" })
public class ClientController {
	
	@Autowired
	private ClientService tenService;
	
	@Autowired
	private SetupsService setupsService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute
	public ModelHelperForm createHelperForm() {
		return new ModelHelperForm();
	}
	
	
	@RequestMapping(value = "clientslist", method = RequestMethod.GET)
	public String tenantList(Model model) {
		return "clients";
	}
	
	
	@RequestMapping(value = "clientsform", method = RequestMethod.GET)
	public String tenantForm(Model model) {
		model.addAttribute("tenId", -2000);
		return "clientsform";
	}
	
	@RequestMapping(value = { "tenants" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ClientDef> getClients(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return tenService.findAllClients(pageable);
	}
	
	
	@RequestMapping(value = "/tenantImage/{tenId}")
	public void getImage(HttpServletResponse response, @PathVariable Long tenId)
			throws IOException, ServletException {
		ClientDef tenant = tenService.getClientDetails(tenId);
		if (tenant.getTenId()!=null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(tenant.getPhoto());
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping(value = { "createClient" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createTenant(ClientDef tenDef) throws IllegalAccessException, IOException, BadRequestException {
		if ((tenDef.getFile() != null) && (!tenDef.getFile().isEmpty())) {
			if (tenDef.getFile().getSize() != 0) {
				tenDef.setPhoto(tenDef.getFile().getBytes());
			} else {

				if (tenDef.getTenId() != null) {
					tenDef.setPhoto(
							setupsService.getClientDetails(tenDef.getTenId()).getPhoto());

				}
			}
		} else {

			if (tenDef.getTenId() != null) {
				tenDef.setPhoto(setupsService.getClientDetails(tenDef.getTenId()).getPhoto());

			}
		}
		 setupsService.defineClient(tenDef);
	}
	
	@RequestMapping(value = { "tenants/{tenId}" }, method = { RequestMethod.GET })
	@ResponseBody
	public ClientDef getAccountDetails(@PathVariable Long tenId) {
		ClientDef tenant =  setupsService.getClientDetails(tenId);
		return tenant;
	}
	
	
	@RequestMapping(value = "/editClientForm", method = RequestMethod.POST)
	public String editRentalForm(@Valid @ModelAttribute ModelHelperForm helperForm, Model model) {
		model.addAttribute("tenId", helperForm.getId());
		return "clientsform";
	}
	

}
