package com.techm.loans.service;

import java.util.List;

import com.techm.loans.model.Customer;

public interface LoanService {
	public Integer sanctionLoan(Customer customer) throws Exception;
	public List<Customer> getReportByLoanType(String loanType) throws Exception;
}
