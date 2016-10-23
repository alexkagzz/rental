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
@Table(name="sys_brk_sections")
public class SectionsDef extends AuditBaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sc_id")
	private Long Id;
	
	@Column(name="sc_sht_desc",nullable=false)
	private String shtDesc;
	
	@Column(name="sc_desc",nullable=false)
	private String desc;
	
	@Column(name="sc_type",nullable=false)
	private String type;
	
	@ManyToOne
	@JoinColumn(name="sc_cov_code")
	private CoverTypesDef coverType;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getShtDesc() {
		return shtDesc;
	}

	public void setShtDesc(String shtDesc) {
		this.shtDesc = shtDesc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CoverTypesDef getCoverType() {
		return coverType;
	}

	public void setCoverType(CoverTypesDef coverType) {
		this.coverType = coverType;
	}


	
	
	
	

}
