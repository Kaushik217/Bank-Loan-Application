package com.techm.loans.model;

import java.util.Objects;

public class Loan {
	private int loanId;
	private double loanAmount;
	private double interestRate;
	private int term;
	private String loanType;
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public Loan() {}
	
	public Loan(int loanId, double loanAmount, double interestRate, int term, String loanType) {
		super();
		this.loanId = loanId;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.term = term;
		this.loanType = loanType;
	}
	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", interestRate=" + interestRate + ", term="
				+ term + ", loanType=" + loanType + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(interestRate, loanAmount, loanId, loanType, term);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate)
				&& Double.doubleToLongBits(loanAmount) == Double.doubleToLongBits(other.loanAmount)
				&& loanId == other.loanId && Objects.equals(loanType, other.loanType) && term == other.term;
	}
	
	
	
}
