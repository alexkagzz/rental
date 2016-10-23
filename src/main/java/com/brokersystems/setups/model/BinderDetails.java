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
@Table(name="sys_brk_binder_det")
public class BinderDetails extends AuditBaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bdet_id")
	private Long detId;
	
	@ManyToOne
	@JoinColumn(name="bdet_bin_code",nullable=false)
	private BindersDef binder;

	
	@ManyToOne
	@JoinColumn(name="bdet_cov_code",nullable=false)
	private CoverTypesDef covertype;
	
	@ManyToOne
	@JoinColumn(name="bdet_sub_code",nullable=false)
	private SubClassDef subclass;

	public Long getDetId() {
		return detId;
	}

	public void setDetId(Long detId) {
		this.detId = detId;
	}

	public BindersDef getBinder() {
		return binder;
	}

	public void setBinder(BindersDef binder) {
		this.binder = binder;
	}

	public CoverTypesDef getCovertype() {
		return covertype;
	}

	public void setCovertype(CoverTypesDef covertype) {
		this.covertype = covertype;
	}

	public SubClassDef getSubclass() {
		return subclass;
	}

	public void setSubclass(SubClassDef subclass) {
		this.subclass = subclass;
	}
	
	
	
}
