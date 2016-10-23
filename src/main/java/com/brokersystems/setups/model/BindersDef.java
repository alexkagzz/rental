package com.brokersystems.setups.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sys_brk_binders")
public class BindersDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bin_id")
	private Long binId;
	
	@ManyToOne
	@JoinColumn(name="bin_acct_code",nullable=false)
	private AccountDef account;
	
	@Column(name="bin_status",nullable=false)
	private boolean active;
	
	@Column(name="bin_sht_desc",nullable=false)
	private String binShtDesc;
	
	@Column(name="bin_name",nullable=false)
	private String binName;
	
	@Column(name="bin_pol_no",nullable=false)
	private String binPolNo;
	
	@ManyToOne
	@JoinColumn(name="bin_pr_code",nullable=false)
	private ProductsDef product;

	public Long getBinId() {
		return binId;
	}

	public void setBinId(Long binId) {
		this.binId = binId;
	}

	public AccountDef getAccount() {
		return account;
	}

	public void setAccount(AccountDef account) {
		this.account = account;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBinShtDesc() {
		return binShtDesc;
	}

	public void setBinShtDesc(String binShtDesc) {
		this.binShtDesc = binShtDesc;
	}

	public String getBinName() {
		return binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
	}

	public String getBinPolNo() {
		return binPolNo;
	}

	public void setBinPolNo(String binPolNo) {
		this.binPolNo = binPolNo;
	}

	public ProductsDef getProduct() {
		return product;
	}

	public void setProduct(ProductsDef product) {
		this.product = product;
	}
	
	

}
