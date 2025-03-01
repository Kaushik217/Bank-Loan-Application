package com.techm.loans.validator;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.techm.loans.model.Loan;

@Component
public class Validator {
	
	public static void validate(Loan loan, Environment environment) throws Exception{
		if(!validateLoanType(loan.getLoanType())) {
			throw new Exception(environment.getProperty("Validator.INVALID_LOANTYPE"));
		}
	}

	public static boolean validateLoanType(String loanType) {
		return loanType != null && (loanType.equalsIgnoreCase("HomeLoan") || loanType.equalsIgnoreCase("CarLoan"));
	}
}
