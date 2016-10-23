package com.brokersystems.transactions.uw.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.brokersystems.setups.model.SectionsDef;

@Entity
@Table(name="sys_brk_rsk_limits")
public class SectionTrans {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sect_id")
	private BigInteger sectId;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="sect_risk_id")
	private RiskTrans risk;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="sect_sec_id")
	private SectionsDef section;
	
	@Column(name="sect_prem")
	private BigDecimal prem;
	
	@Column(name="sect_amount")
	private BigDecimal amount;
	
	@Column(name="sect_rate")
	private BigDecimal rate;
	
	@Column(name="sect_div_fact",nullable=false)
	private BigDecimal divFactor;
	
	@Column(name="sect_free_limit")
	private BigDecimal freeLimit;
	
	@Column(name="sect_allowed")
	private boolean compute;

	public BigInteger getSectId() {
		return sectId;
	}

	public void setSectId(BigInteger sectId) {
		this.sectId = sectId;
	}

	public RiskTrans getRisk() {
		return risk;
	}

	public void setRisk(RiskTrans risk) {
		this.risk = risk;
	}

	public SectionsDef getSection() {
		return section;
	}

	public void setSection(SectionsDef section) {
		this.section = section;
	}

	public BigDecimal getPrem() {
		return prem;
	}

	public void setPrem(BigDecimal prem) {
		this.prem = prem;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getDivFactor() {
		return divFactor;
	}

	public void setDivFactor(BigDecimal divFactor) {
		this.divFactor = divFactor;
	}

	public BigDecimal getFreeLimit() {
		return freeLimit;
	}

	public void setFreeLimit(BigDecimal freeLimit) {
		this.freeLimit = freeLimit;
	}

	public boolean isCompute() {
		return compute;
	}

	public void setCompute(boolean compute) {
		this.compute = compute;
	}
	
	
	
	
	
	
	

}
