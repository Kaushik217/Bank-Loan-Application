package com.techm.loans.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.loans.entity.LoanEntity;
import com.techm.loans.model.Customer;

public interface LoanDAO extends JpaRepository<LoanEntity, Integer>{
	
	public List<Customer> getReportByLoanType(String loanType);
	public Integer checkLoanAllotment(Integer customerId);
	public Integer sanctionLoan(Customer customer);
}
