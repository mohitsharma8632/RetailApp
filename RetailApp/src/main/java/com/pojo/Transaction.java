package com.pojo;

public class Transaction {
	private String customerid;
	private String accounttype;
	private String amount;
	private String date;
	private String sourceaccounttype;
	private String targetaccounttype;
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSourceaccounttype() {
		return sourceaccounttype;
	}
	public void setSourceaccounttype(String sourceaccounttype) {
		this.sourceaccounttype = sourceaccounttype;
	}
	public String getTargetaccounttype() {
		return targetaccounttype;
	}
	public void setTargetaccounttype(String targetaccounttype) {
		this.targetaccounttype = targetaccounttype;
	}
	
}
