package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonType;
@Entity
@Table(name="interestrate")
@TypeDef(name = "json", typeClass = JsonType.class)
public class InterestRate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int interestId;
    
    private String rateSpecificationCode;
    
    @NaturalId
    @Column
    private String name;
    private String description;
    private String currency;
    private String validFrom;
    private String validTill;
    
    @Column(name="is_delete")
    private boolean isDelete;
     
	public int getInterestId() {
		return interestId;
	}
	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}
	public String getRateSpecificationCode() {
		return rateSpecificationCode;
	}
	public void setRateSpecificationCode(String rateSpecificationCode) {
		this.rateSpecificationCode = rateSpecificationCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
    
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
    


}
