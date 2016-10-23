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
@Table(name="sys_brk_products")
public class ProductsDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pr_code")
	private Long proCode;
	
	@Column(name="pr_sht_desc", nullable=false,unique=true)
	private String proShtDesc;
	
	@Column(name="pr_desc", nullable=false)
	private String proDesc;
	
	@Column(name="pr_pol_prefix")
	private String proPolPrefix;
	
	@Column(name="pr_clm_prefix")
	private String proClmPrefix;
	
	@Column(name="pr_multi_sub_class")
	private boolean multiSubClass;
	
	@Column(name="pr_renewable")
	private boolean renewable;
	
	@Column(name="pr_active")
	private boolean active;
	
	
	@ManyToOne
	@JoinColumn(name="pr_bpg_code",nullable=false)
	private ProductGroupDef proGroup;

	public Long getProCode() {
		return proCode;
	}

	public void setProCode(Long proCode) {
		this.proCode = proCode;
	}

	public String getProShtDesc() {
		return proShtDesc;
	}

	public void setProShtDesc(String proShtDesc) {
		this.proShtDesc = proShtDesc;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getProPolPrefix() {
		return proPolPrefix;
	}

	public void setProPolPrefix(String proPolPrefix) {
		this.proPolPrefix = proPolPrefix;
	}

	public String getProClmPrefix() {
		return proClmPrefix;
	}

	public void setProClmPrefix(String proClmPrefix) {
		this.proClmPrefix = proClmPrefix;
	}

	public boolean isMultiSubClass() {
		return multiSubClass;
	}

	public void setMultiSubClass(boolean multiSubClass) {
		this.multiSubClass = multiSubClass;
	}

	public boolean isRenewable() {
		return renewable;
	}

	public void setRenewable(boolean renewable) {
		this.renewable = renewable;
	}

	public ProductGroupDef getProGroup() {
		return proGroup;
	}

	public void setProGroup(ProductGroupDef proGroup) {
		this.proGroup = proGroup;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
