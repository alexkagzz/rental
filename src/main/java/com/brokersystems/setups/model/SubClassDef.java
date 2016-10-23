package com.brokersystems.setups.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_brk_subclasses")
public class SubClassDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_id")
	private Long subId;
	
	@Column(name="sub_sht_desc",nullable=false)
	private String subShtDesc;
	
	@Column(name="sub_desc",nullable=false)
	private String subDesc;
	
	@Column(name="sub_status",nullable=false)
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="sub_cl_code",nullable=false)
	private ClassesDef classDef;
	
	@Column(name="sub_rsk_uniq",nullable=false)
	private boolean riskUnique;
	
	@JsonIgnore
	@OneToMany(mappedBy="subclass")
	private List<CoverTypesDef> coverTypes;
	
	@JsonIgnore
	@OneToMany(mappedBy="subclass")
	private List<ClausesDef> clauses;
	
	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getSubShtDesc() {
		return subShtDesc;
	}

	public void setSubShtDesc(String subShtDesc) {
		this.subShtDesc = subShtDesc;
	}

	public String getSubDesc() {
		return subDesc;
	}

	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClassesDef getClassDef() {
		return classDef;
	}

	public void setClassDef(ClassesDef classDef) {
		this.classDef = classDef;
	}

	public boolean isRiskUnique() {
		return riskUnique;
	}

	public void setRiskUnique(boolean riskUnique) {
		this.riskUnique = riskUnique;
	}


	public List<CoverTypesDef> getCoverTypes() {
		return coverTypes;
	}

	public void setCoverTypes(List<CoverTypesDef> coverTypes) {
		this.coverTypes = coverTypes;
	}

	public List<ClausesDef> getClauses() {
		return clauses;
	}

	public void setClauses(List<ClausesDef> clauses) {
		this.clauses = clauses;
	}
	
	
	
}
