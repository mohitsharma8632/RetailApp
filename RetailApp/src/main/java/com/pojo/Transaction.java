package com.pojo;

public class Transaction {
	private int sourceaccountid;
	private String sourceaccounttype;
	private int amount;
	private String date;
	private int targetaccountid;
	private String targetaccounttype;
	private int transactionid;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSourceaccountid() {
		return sourceaccountid;
	}
	public void setSourceaccountid(int sourceaccountid) {
		this.sourceaccountid = sourceaccountid;
	}
	public String getSourceaccounttype() {
		return sourceaccounttype;
	}
	public void setSourceaccounttype(String sourceaccounttype) {
		this.sourceaccounttype = sourceaccounttype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTargetaccountid() {
		return targetaccountid;
	}
	public void setTargetaccountid(int targetaccountid) {
		this.targetaccountid = targetaccountid;
	}
	public String getTargetaccounttype() {
		return targetaccounttype;
	}
	public void setTargetaccounttype(String targetaccounttype) {
		this.targetaccounttype = targetaccounttype;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	
}
