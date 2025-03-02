package com.techm.loans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.techm.loans.dao.LoanDAO;
import com.techm.loans.model.Customer;
import com.techm.loans.model.Loan;
import com.techm.loans.service.LoanService;

@SpringBootTest
class BankLoanTraineeApplicationTests {
	
	@Autowired
	LoanDAO loanDAO;
	@Autowired
	LoanService loanService;
	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
	}
	
	//test that if the customer is not found.
	@Test
	public void sanctionLoanCustomerNotAvailableTest() {
		try {
			loanService.sanctionLoan(new Customer(9999, "TestName", 1234567890, new Loan(9999, 123.0, 10.0, 10, "HomeLoan"),0));
		}
		catch (Exception e) {
			assert e.getMessage().contains(environment.getProperty("Service.CUSTOMER_UNAVAILABLE"));
		}
	}
	
	//Test that if the loan is already sanctioned to the custmer
	@Test
	public void sanctionLoanLoanAlreadyTakenTest() {
		try {
			loanService.sanctionLoan(new Customer(1, "Markel", 8765432112L, new Loan(1, 1200000.0, 13.0, 15, "HomeLoan"),0));
		}
		catch (Exception e) {
			assert e.getMessage().contains(environment.getProperty("Service.LOAN_ALREADY_TAKEN"));
		}
	}

}
