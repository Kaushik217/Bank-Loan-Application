package com.techm.loans.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.loans.model.Customer;
import com.techm.loans.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanAPI {
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	public Environment environment;
	
	@PostMapping("/loan")
	public ResponseEntity<String> sanctionLoan(@RequestBody Customer customer){
		try {
			//sanction the loan and retrieve the loanId
			Integer loanId = loanService.sanctionLoan(customer);
			
			//success message with loanId
			String success = environment.getProperty("API.SANCTION_SUCCESS") + " " + loanId;
			
			//return a success response with the created message.
			return ResponseEntity.status(HttpStatus.CREATED).body(environment.getProperty("API.SANCTION_SUCCESS") + " " + loanId);
		}
		catch (Exception e) {
			e.printStackTrace();
			//if any exception occurs return the bad request response with an exception message.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{loanType}")
	public ResponseEntity<List<Customer>> getReportByLoanType(@PathVariable String loanType) throws Exception{
		try {
			//retrieve details for a specific loanType
			List<Customer> customers = loanService.getReportByLoanType(loanType);
			
			//return the fetched details for the loan type
			return ResponseEntity.ok().body(loanService.getReportByLoanType(loanType));
		}
		catch(RuntimeException e) {
			//if an exception occurs throw the NOT_FOUND response status.
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
