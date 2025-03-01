package com.techm.loans.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan")
public class LoanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="loan_id")
	private int loanId;
	
	@Column(name = "loan_amount")
	private double loanAmount;
	
	@Column(name = "interest_rate")
	private double interstRate;
	
	@Column(name = "term")
	private int term;
	
	@Column(name = "loan_type")
	private String loanType;
	
	public LoanEntity() {}

	public LoanEntity(int loanId, double loanAmount, double interstRate, int term, String loanType) {
		super();
		this.loanId = loanId;
		this.loanAmount = loanAmount;
		this.interstRate = interstRate;
		this.term = term;
		this.loanType = loanType;
	}

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

	public double getInterstRate() {
		return interstRate;
	}

	public void setInterstRate(double interstRate) {
		this.interstRate = interstRate;
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

	@Override
	public int hashCode() {
		return Objects.hash(interstRate, loanAmount, loanId, loanType, term);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanEntity other = (LoanEntity) obj;
		return Double.doubleToLongBits(interstRate) == Double.doubleToLongBits(other.interstRate)
				&& Double.doubleToLongBits(loanAmount) == Double.doubleToLongBits(other.loanAmount)
				&& loanId == other.loanId && Objects.equals(loanType, other.loanType) && term == other.term;
	}

	@Override
	public String toString() {
		return "LoanEntity [loanId=" + loanId + ", loanAmount=" + loanAmount + ", interstRate=" + interstRate
				+ ", term=" + term + ", loanType=" + loanType + "]";
	}
	
	
	
}
