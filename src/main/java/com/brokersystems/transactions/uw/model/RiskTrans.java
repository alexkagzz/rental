package com.brokersystems.transactions.uw.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import com.brokersystems.setups.model.BindersDef;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.CoverTypesDef;
import com.brokersystems.setups.model.SubClassDef;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="sys_brk_risks")
public class RiskTrans {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="risk_id")
	private BigInteger riskId;
	
	@Column(name="risk_sht_desc")
	private String riskShtDesc;
	
	@Column(name="risk_desc")
	private String riskDesc;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="risk_pol_id")
	private PolicyTrans policy;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="risk_insured_id")
	private ClientDef insured;
	
	
	@Column(name="risk_wef_date", nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date wefDate;
	
	@Column(name="risk_wet_date",nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date wetDate;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="risk_binder_id")
	private BindersDef binder;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="risk_subclass_id")
	private SubClassDef subclass;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="risk_cover_id")
	private CoverTypesDef covertype;
	
	@Column(name="risk_sum_insur_amt")
	private BigDecimal sumInsured;
	
	@Column(name="risk_premium_amt")
	private BigDecimal premium;
	
	@Column(name="risk_taxes")
	private BigDecimal taxes;
	
	@Column(name="risk_future_prem")
	private BigDecimal futurePrem;
	
	@Column(name="risk_comm_rate")
	private BigDecimal commRate;
	
	@Column(name="risk_comm_amt")
	private BigDecimal commAmt;
	
	@Column(name="risk_prorata")
	private String prorata;

	public BigInteger getRiskId() {
		return riskId;
	}

	public void setRiskId(BigInteger riskId) {
		this.riskId = riskId;
	}

	public String getRiskShtDesc() {
		return riskShtDesc;
	}

	public void setRiskShtDesc(String riskShtDesc) {
		this.riskShtDesc = riskShtDesc;
	}

	public String getRiskDesc() {
		return riskDesc;
	}

	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc;
	}

	public PolicyTrans getPolicy() {
		return policy;
	}

	public void setPolicy(PolicyTrans policy) {
		this.policy = policy;
	}

	public ClientDef getInsured() {
		return insured;
	}

	public void setInsured(ClientDef insured) {
		this.insured = insured;
	}

	public Date getWefDate() {
		return wefDate;
	}

	public void setWefDate(Date wefDate) {
		this.wefDate = wefDate;
	}

	public Date getWetDate() {
		return wetDate;
	}

	public void setWetDate(Date wetDate) {
		this.wetDate = wetDate;
	}

	public BindersDef getBinder() {
		return binder;
	}

	public void setBinder(BindersDef binder) {
		this.binder = binder;
	}

	public SubClassDef getSubclass() {
		return subclass;
	}

	public void setSubclass(SubClassDef subclass) {
		this.subclass = subclass;
	}

	public CoverTypesDef getCovertype() {
		return covertype;
	}

	public void setCovertype(CoverTypesDef covertype) {
		this.covertype = covertype;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public BigDecimal getFuturePrem() {
		return futurePrem;
	}

	public void setFuturePrem(BigDecimal futurePrem) {
		this.futurePrem = futurePrem;
	}

	public BigDecimal getCommRate() {
		return commRate;
	}

	public void setCommRate(BigDecimal commRate) {
		this.commRate = commRate;
	}

	public BigDecimal getCommAmt() {
		return commAmt;
	}

	public void setCommAmt(BigDecimal commAmt) {
		this.commAmt = commAmt;
	}

	public String getProrata() {
		return prorata;
	}

	public void setProrata(String prorata) {
		this.prorata = prorata;
	}
	
	
	
	
	
	

}
