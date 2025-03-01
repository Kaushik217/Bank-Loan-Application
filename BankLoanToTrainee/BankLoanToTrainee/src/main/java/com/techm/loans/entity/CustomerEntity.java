package com.techm.loans.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "name")
	private String customerName;
	
	@Column(name = "mobile_no")
	private long mobileNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_id")
	private LoanEntity loan;
	
	public CustomerEntity() {}
	
	

	public CustomerEntity(int customerId, String customerName, long mobileNo, LoanEntity loan) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.loan = loan;
	}

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

	public LoanEntity getLoan() {
		return loan;
	}

	public void setLoan(LoanEntity loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo
				+ ", loan=" + loan + "]";
	}
	
	
	
}
