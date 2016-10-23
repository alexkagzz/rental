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

import com.brokersystems.setups.model.AccountDef;
import com.brokersystems.setups.model.BindersDef;
import com.brokersystems.setups.model.ClientDef;
import com.brokersystems.setups.model.Currencies;
import com.brokersystems.setups.model.OrgBranch;
import com.brokersystems.setups.model.PaymentModes;
import com.brokersystems.setups.model.ProductsDef;
import com.brokersystems.setups.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_brk_policies")
public class PolicyTrans {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pol_id")
	private BigInteger policyId;
	
	@Column(name="pol_no",nullable=false)
	private String polNo;
	
	@Column(name="pol_old_no")
	private String OldpolNo;
	
	@Column(name="pol_client_pol_no")
	private String clientPolNo;
	
	@Column(name="pol_rev_no",nullable=false)
	private String polRevNo;
	
	@Column(name="pol_rev_status",nullable=false)
	private String polRevStatus;
	
	@Column(name="pol_date",nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date pol_date;
	
	@Column(name="pol_wef_date", nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date wefDate;
	
	@Column(name="pol_wet_date",nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date wetDate;
	
	@Column(name="pol_ren_date",nullable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date renewalDate;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_client_id")
	private ClientDef client;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_agent_id")
	private AccountDef agent;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_branch_id")
	private OrgBranch branch;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_pmode_id")
	private PaymentModes paymentMode;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_curr_id")
	private Currencies transCurrency;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_prod_id")
	private ProductsDef product;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_binder_id")
	private BindersDef binder;
	
	@Column(name="pol_status")
	private String status;
	
	@Column(name="pol_ref_no")
	private String refNo;
	
	@XmlTransient
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="pol_prev_policy")
	private PolicyTrans previousTrans;
	
	@Column(name="pol_current_status")
	private String currentStatus;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_auth_user")
	private User authBy;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="pol_created_user",nullable=false)
	private User createdUser;
	
	@Column(name="pol_sum_insur_amt")
	private BigDecimal sumInsured;
	
	@Column(name="pol_premium_amt")
	private BigDecimal premium;
	
	@Column(name="pol_future_prem")
	private BigDecimal futurePrem;
	
	@Column(name="pol_taxes")
	private BigDecimal taxes;
	
	@Column(name="pol_com_allowed")
	private boolean commAllowed;
	
	@Column(name="pol_uw_yr")
	private Integer uwYear;
	
	

	public boolean isCommAllowed() {
		return commAllowed;
	}

	public void setCommAllowed(boolean commAllowed) {
		this.commAllowed = commAllowed;
	}

	public Integer getUwYear() {
		return uwYear;
	}

	public void setUwYear(Integer uwYear) {
		this.uwYear = uwYear;
	}

	public BigInteger getPolicyId() {
		return policyId;
	}

	public void setPolicyId(BigInteger policyId) {
		this.policyId = policyId;
	}

	public String getPolNo() {
		return polNo;
	}

	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}

	public String getOldpolNo() {
		return OldpolNo;
	}

	public void setOldpolNo(String oldpolNo) {
		OldpolNo = oldpolNo;
	}

	public String getClientPolNo() {
		return clientPolNo;
	}

	public void setClientPolNo(String clientPolNo) {
		this.clientPolNo = clientPolNo;
	}

	public String getPolRevNo() {
		return polRevNo;
	}

	public void setPolRevNo(String polRevNo) {
		this.polRevNo = polRevNo;
	}

	public Date getPol_date() {
		return pol_date;
	}

	public void setPol_date(Date pol_date) {
		this.pol_date = pol_date;
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

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public ClientDef getClient() {
		return client;
	}

	public void setClient(ClientDef client) {
		this.client = client;
	}

	public AccountDef getAgent() {
		return agent;
	}

	public void setAgent(AccountDef agent) {
		this.agent = agent;
	}

	public OrgBranch getBranch() {
		return branch;
	}

	public void setBranch(OrgBranch branch) {
		this.branch = branch;
	}

	public PaymentModes getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentModes paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Currencies getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(Currencies transCurrency) {
		this.transCurrency = transCurrency;
	}

	public ProductsDef getProduct() {
		return product;
	}

	public void setProduct(ProductsDef product) {
		this.product = product;
	}

	public BindersDef getBinder() {
		return binder;
	}

	public void setBinder(BindersDef binder) {
		this.binder = binder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public PolicyTrans getPreviousTrans() {
		return previousTrans;
	}

	public void setPreviousTrans(PolicyTrans previousTrans) {
		this.previousTrans = previousTrans;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public User getAuthBy() {
		return authBy;
	}

	public void setAuthBy(User authBy) {
		this.authBy = authBy;
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

	public BigDecimal getFuturePrem() {
		return futurePrem;
	}

	public void setFuturePrem(BigDecimal futurePrem) {
		this.futurePrem = futurePrem;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public String getPolRevStatus() {
		return polRevStatus;
	}

	public void setPolRevStatus(String polRevStatus) {
		this.polRevStatus = polRevStatus;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	
	
	
}
