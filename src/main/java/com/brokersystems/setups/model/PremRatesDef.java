package com.brokersystems.setups.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sys_brk_prem_rts")
public class PremRatesDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prem_id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="prem_bd_code",nullable=false)
	private BinderDetails binderDet;
	
	@ManyToOne
	@JoinColumn(name="prem_sec_code",nullable=false)
	private SectionsDef section;
	
	@Column(name="prem_status",nullable=false)
	private boolean active;
	
	@Column(name="prem_rate",nullable=false)
	private BigDecimal rate;
	
	@Column(name="prem_range_from",nullable=false)
	private BigDecimal rangeFrom;
	
	@Column(name="prem_range_to",nullable=false)
	private BigDecimal rangeTo;
	
	@Column(name="prem_rate_type",nullable=false)
	private String rateType;
	
	@Column(name="prem_div_fact",nullable=false)
	private BigDecimal divFactor;
	
	@Column(name="prem_prorate_full",nullable=false)
	private String proratedFull;
	
	@Column(name="prem_free_limit")
	private BigDecimal freeLimit;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public BinderDetails getBinderDet() {
		return binderDet;
	}

	public void setBinderDet(BinderDetails binderDet) {
		this.binderDet = binderDet;
	}

	public SectionsDef getSection() {
		return section;
	}

	public void setSection(SectionsDef section) {
		this.section = section;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(BigDecimal rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public BigDecimal getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(BigDecimal rangeTo) {
		this.rangeTo = rangeTo;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public BigDecimal getDivFactor() {
		return divFactor;
	}

	public void setDivFactor(BigDecimal divFactor) {
		this.divFactor = divFactor;
	}

	public String getProratedFull() {
		return proratedFull;
	}

	public void setProratedFull(String proratedFull) {
		this.proratedFull = proratedFull;
	}

	public BigDecimal getFreeLimit() {
		return freeLimit;
	}

	public void setFreeLimit(BigDecimal freeLimit) {
		this.freeLimit = freeLimit;
	}
	
	
	
	
	

}
