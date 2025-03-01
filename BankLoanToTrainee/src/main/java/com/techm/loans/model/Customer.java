package com.techm.loans.model;

public class Customer {
	private int customerId;
	private String customerName;
	private long mobileNo;
	private Loan loan;
	private double emi;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public long getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Loan getLoan() {
		return loan;
	}
	
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	public double getEmi() {
		return emi;
	}
	
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	
	public Customer() {}

	public Customer(int customerId, String customerName, long mobileNo, Loan loan, double emi) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.loan = loan;
		this.emi = emi;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo
				+ ", loan=" + loan + ", emi=" + emi + "]";
	}

}
