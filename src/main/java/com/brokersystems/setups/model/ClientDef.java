package com.brokersystems.setups.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_brk_clients")
public class ClientDef {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="client_id")
	private Long tenId;
	
	@Column(name="client_sht_desc",nullable=false,unique=true)
	private String tenantNumber;
	
	@Column(name="client_fname",nullable=false)
    private String fname;
    
	@Column(name="client_onames",nullable=false)
    private String otherNames;
    
	@Column(name="client_address")
    private String address;
    
	@Column(name="client_email")
    private String emailAddress;
    
	@Column(name="client_phone",nullable=false)
    private String phoneNo;
    
	@Column(name="client_dob",nullable=false)
    private Date dob;
    
	@Column(name="client_pin")
    private String pinNo;
    
	@Column(name="client_idno",nullable=false)
    private String idPassport;
    
    @Lob
	@JsonIgnore
	@Column(name="client_photo")
	private byte[] photo;
    
    @Column(name="client_clnt_type",nullable=false)
    private String tenantType;
    
    @Column(name="client_datereg",nullable=false)
    private Date dateregistered;
    
    @Column(name="client_datetermin")
    private Date dateterminated;
    
    @Column(name="client_status",nullable=false)
    private String status;
    
    
    @ManyToOne
	@JoinColumn(name="client_brn_code",nullable=false)
	private OrgBranch registeredbrn;
    
    @Transient
	MultipartFile file;
    
    
  

	public Long getTenId() {
		return tenId;
	}

	public void setTenId(Long tenId) {
		this.tenId = tenId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getIdPassport() {
		return idPassport;
	}

	public void setIdPassport(String idPassport) {
		this.idPassport = idPassport;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getTenantType() {
		return tenantType;
	}

	public void setTenantType(String tenantType) {
		this.tenantType = tenantType;
	}

	public Date getDateregistered() {
		return dateregistered;
	}

	public void setDateregistered(Date dateregistered) {
		this.dateregistered = dateregistered;
	}

	public Date getDateterminated() {
		return dateterminated;
	}

	public void setDateterminated(Date dateterminated) {
		this.dateterminated = dateterminated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrgBranch getRegisteredbrn() {
		return registeredbrn;
	}

	public void setRegisteredbrn(OrgBranch registeredbrn) {
		this.registeredbrn = registeredbrn;
	}

	public String getTenantNumber() {
		return tenantNumber;
	}

	public void setTenantNumber(String tenantNumber) {
		this.tenantNumber = tenantNumber;
	}


	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
