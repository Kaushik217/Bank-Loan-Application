package com.techm.loans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.techm.loans.dao.LoanDAO;
import com.techm.loans.model.Customer;
import com.techm.loans.validator.Validator;

import jakarta.transaction.Transactional;

@Service(value = "LoanService")
@Transactional
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanDAO loanDAOImpl;
	
	@Autowired
	Environment environment;

	@Override
	public Integer sanctionLoan(Customer customer) throws Exception {
		//Validate loan Type
		Validator.validate(customer.getLoan(), environment);
		int result = loanDAOImpl.checkLoanAllotment(customer.getCustomerId());
		
		//if no loan has been alloted
		if(result == 0) {
			return loanDAOImpl.sanctionLoan(customer);
		}
		else if(result == -1) {
			throw new Exception(environment.getProperty("Service.CUSTOMER_UNAVAILABLE"));
		}
		else {
			throw new Exception(environment.getProperty("Service.LOAN_ALREADY_TAKEN"));
		}
	}

	@Override
	public List<Customer> getReportByLoanType(String loanType) throws Exception {
		
		List<Customer> l = loanDAOImpl.getReportByLoanType(loanType);
		if(l.isEmpty()) {
			throw new Exception(environment.getProperty("Service.NO_LOAN_FOUND"));
		}
		
		else
			return l;
	}
	

}
