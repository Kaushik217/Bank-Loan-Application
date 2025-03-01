package com.techm.loans.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.techm.loans.entity.CustomerEntity;
import com.techm.loans.entity.LoanEntity;
import com.techm.loans.model.Customer;
import com.techm.loans.model.Loan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoanDAOImpl implements LoanDAO{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public List<Customer> getReportByLoanType(String loanType){
		
		String s = "SELECT c FROM CustomerEntity c WHERE c.loan.loanType=:loanType";
		
		TypedQuery<CustomerEntity> q = entitymanager.createQuery(s,CustomerEntity.class);
		q.setParameter("loanType", loanType);
		
		//Initialize a list to hold the result
		List<Customer> customers = new ArrayList<>();
		
		//Iterate through the results of the query.
		
		for(CustomerEntity customerEntity: q.getResultList()) {
			
			//populate the loan object data with the customerEntity's Associated with loanEntity
			Loan loan = new Loan();
			loan.setLoanId(customerEntity.getLoan().getLoanId());
			loan.setLoanAmount(customerEntity.getLoan().getLoanAmount());
			loan.setInterestRate(customerEntity.getLoan().getInterstRate());
			loan.setTerm(customerEntity.getLoan().getTerm());
			loan.setLoanType(customerEntity.getLoan().getLoanType());
			double emi = calculateEMI(loan.getLoanAmount(), loan.getInterestRate(), loan.getTerm());
			
			//populate the customer object with the data from customerEntity
			Customer c = new Customer();
			c.setCustomerId(customerEntity.getCustomerId());
			c.setCustomerName(customerEntity.getCustomerName());
			c.setMobileNo(customerEntity.getMobileNo());
			c.setLoan(loan);
			
			c.setEmi(emi);
			customers.add(c);
		}
		return customers;
		
	}
	
	@Override
	public Integer checkLoanAllotment(Integer customerId) {
		
		CustomerEntity customerEntity = entitymanager.find(CustomerEntity.class, customerId);
		//customer not found
		if(customerEntity==null) {
			return -1;
		}
		
		//customer not having a loan
		if(customerEntity.getLoan() == null) {
			return 0;
		}
		
		return customerEntity.getLoan().getLoanId();
	}
	
	@Override
	public Integer sanctionLoan(Customer customer) {
		
		CustomerEntity customerEntity = entitymanager.find(CustomerEntity.class, customer.getCustomerId());
		
		//create loanEntity object
		LoanEntity loanEntity = new LoanEntity();
		
		//populate loan details from customer model
		loanEntity.setLoanAmount(customer.getLoan().getLoanAmount());
		loanEntity.setLoanType(customer.getLoan().getLoanType());
		
		//set interest rate and term based on the loan type
		if(customer.getLoan().getLoanType().equalsIgnoreCase("HomeLoan")) {
			loanEntity.setInterstRate(13.0);
			loanEntity.setTerm(15);
		}
		else {
			loanEntity.setInterstRate(9.0);
			loanEntity.setTerm(5);
		}
		
		//persist loan details to the database 
		entitymanager.persist(loanEntity);
		
		//update the customeEntity of sanctioned loan and merge into the database
		customerEntity.setLoan(loanEntity);
		entitymanager.merge(customerEntity);
		return loanEntity.getLoanId();
	}
	
	private double calculateEMI(double loanAmount, double interestRate, int term) {
		return Math.ceil((loanAmount+ (loanAmount * term * interestRate)/100) / (term*12));
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends LoanEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<LoanEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoanEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanEntity getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanEntity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<LoanEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LoanEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends LoanEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoanEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LoanEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends LoanEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends LoanEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends LoanEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends LoanEntity, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
