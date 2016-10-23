package com.brokersystems.setup.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brokersystems.server.datatables.DataTable;
import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.model.ClassesDef;
import com.brokersystems.setups.model.ClausesDef;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.CoverTypesDef;
import com.brokersystems.setups.model.SectionsDef;
import com.brokersystems.setups.model.SubClassDef;
import com.brokersystems.setups.service.ClassesService;

@Controller
@RequestMapping({ "/protected/setups/classes" })
public class ClassesController {
	
	@Autowired
	private ClassesService classService;
	
	
	@RequestMapping(value = "classesHome",method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public String classHome(Model model)
	  {
	    return "classes";
	  }
	
	@RequestMapping(value = { "classesList" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ClassesDef> getClasses(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return classService.findAllClasses(pageable);
	}
	
	@RequestMapping(value = { "createClassDef" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createClass(ClassesDef classDef) throws IllegalAccessException, IOException, BadRequestException {
		classService.createClass(classDef);
	}
	
	@RequestMapping(value = { "subclassList/{classCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<SubClassDef> getSubclasses(@DataTable DataTablesRequest pageable,@PathVariable Long classCode)
			throws IllegalAccessException {
		return classService.findAllSubclass(pageable,classCode);
	}
	
	@RequestMapping(value = { "createSubClass" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createSubclass(SubClassDef subclass) throws IllegalAccessException, IOException, BadRequestException {
		classService.createSubClass(subclass);
	}
	
	
	@RequestMapping(value = { "coverTypes/{subCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<CoverTypesDef> getCoverTypes(@DataTable DataTablesRequest pageable,@PathVariable Long subCode)
			throws IllegalAccessException {
		return classService.findAllCOverTypes(pageable,subCode);
	}
	
	@RequestMapping(value = { "createCoverType" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createCoverType(CoverTypesDef coverType) throws IllegalAccessException, IOException, BadRequestException {
		classService.createCoverType(coverType);
	}
	
	@RequestMapping(value = { "sections/{covtCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<SectionsDef> getSections(@DataTable DataTablesRequest pageable,@PathVariable Long covtCode)
			throws IllegalAccessException {
		return classService.findCoverTypeSections(pageable,covtCode);
	}
	
	@RequestMapping(value = { "createSection" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createSection(SectionsDef section) throws IllegalAccessException, IOException, BadRequestException {
		classService.createSection(section);
	}
	
	@RequestMapping(value = { "clauses/{subCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ClausesDef> getClauses(@DataTable DataTablesRequest pageable,@PathVariable Long subCode)
			throws IllegalAccessException {
		return classService.findAllClauses(pageable, subCode);
	}
	
	@RequestMapping(value = { "createClause" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public void createClause(ClausesDef clause) throws IllegalAccessException, IOException, BadRequestException {
		classService.createClause(clause);
	}

}
