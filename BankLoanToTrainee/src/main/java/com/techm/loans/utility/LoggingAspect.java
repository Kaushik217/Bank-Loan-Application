package com.techm.loans.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.techm.loans.BankLoanTraineeApplication;

@Aspect
@Component
public class LoggingAspect {
	
	public static final Logger logger = LoggerFactory.getLogger(BankLoanTraineeApplication.class);
	
	@AfterThrowing(value = "execution(* com.techm.loans.dao.LoanDAOImpl.*(..))", throwing = "exception")
	public void logDaoException(Exception exception) {
		logger.error("Exception in LoanDAOImpl: {}", exception.getMessage(), exception);
	}
	
	@AfterThrowing(value = "execution(* com.techm.loans.service.LoanServiceImpl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		logger.info("After Throwing");
		logger.error("Exception in LoanServiceImpl: {}", exception.getMessage(), exception);
	}
}
