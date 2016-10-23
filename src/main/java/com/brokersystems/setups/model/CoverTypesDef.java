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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_brk_covertypes")
public class CoverTypesDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cov_id")
	private Long covId;
	
	@Column(name="cov_active",nullable=false)
	private boolean active;
	
	@Column(name="cov_sht_desc",nullable=false)
	private String covShtDesc;
	
	@Column(name="cov_desc",nullable=false)
	private String covName;
	
	@ManyToOne
	@JoinColumn(name="cov_sub_code")
	private SubClassDef subclass;
	

	public Long getCovId() {
		return covId;
	}

	public void setCovId(Long covId) {
		this.covId = covId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCovShtDesc() {
		return covShtDesc;
	}

	public void setCovShtDesc(String covShtDesc) {
		this.covShtDesc = covShtDesc;
	}

	public String getCovName() {
		return covName;
	}

	public void setCovName(String covName) {
		this.covName = covName;
	}

	public SubClassDef getSubclass() {
		return subclass;
	}

	public void setSubclass(SubClassDef subclass) {
		this.subclass = subclass;
	}

	
	
}
