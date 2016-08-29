package com.soni.app.batch.model;

import java.util.Date;

public class TraditionalLifeAddPolicyRequest {
	private String policyNumber;
	
	private Date runDate;
	
	private String productType;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	

}
