package com.iiht.evaluation.eloan.model;

public class LoanInfo {
	private String UserName;
	private String applno;
	 private String purpose;
	 private int amtrequest;
	 private String doa;
	 private String bstructure;
	 private String bindicator;
	 private String TaxIndicator;
	 private String address;
	 private String PinCode;
	 	private String email;
	 private Long mobile;
	 private String status;
	public String getUserName() {
		return this.UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getApplno() {
		return applno;
	}
	public void setApplno(String applno) {
		this.applno = applno;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getAmtrequest() {
		return amtrequest;
	}
	public void setAmtrequest(int amtrequest) {
		this.amtrequest = amtrequest;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getBstructure() {
		return bstructure;
	}
	public void setBstructure(String bstructure) {
		this.bstructure = bstructure;
	}
	public String getBindicator() {
		return bindicator;
	}
	public void setBindicator(String bindicator) {
		this.bindicator = bindicator;
	}
	public String getTaxIndicator() {
		return TaxIndicator;
	}
	public void setTaxIndicator(String taxIndicator) {
		TaxIndicator = taxIndicator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoanInfo(String userName, String applno, String purpose, int amtrequest, String doa, String bstructure,
			String bindicator, String taxIndicator, String address, String pinCode, String email, Long mobile,
			String status) {
		super();
		UserName = userName;
		this.applno = applno;
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		TaxIndicator = taxIndicator;
		this.address = address;
		PinCode = pinCode;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}
	public LoanInfo(String applno,String purpose, int amtrequest, String doa, String bstructure,
			String bindicator, String taxIndicator, String address, String pinCode, String email, Long mobile) {
		super();
		this.applno=  applno;
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		TaxIndicator = taxIndicator;
		this.address = address;
		PinCode = pinCode;
		this.email = email;
		this.mobile = mobile;
		
	}
	public LoanInfo(String applno) {
		super();
		this.applno = applno;
	}
	
	public LoanInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "LoanInfo [UserName=" + UserName + ", applno=" + applno + ", purpose=" + purpose + ", amtrequest="
				+ amtrequest + ", doa=" + doa + ", bstructure=" + bstructure + ", bindicator=" + bindicator
				+ ", TaxIndicator=" + TaxIndicator + ", address=" + address + ", PinCode=" + PinCode + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + "]";
	}
	 
	
}
