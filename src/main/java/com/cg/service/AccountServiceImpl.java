package com.cg.service;

import java.util.List;
import com.cg.eceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.AccountRepository;
import com.cg.dto.Account;
import com.cg.dto.Customer;

@Service
public class AccountServiceImpl implements AccountService {
@Autowired
private CustomerService customerService;
@Autowired
private AccountRepository accountDao;
	public Account addAccount(Customer customer) 
	{
		Account account = new Account();
		if(customerService.findByAadhar(customer.getAadhar()).isEmpty())
		{
		customerService.addCustomer(customer);
		
		
		account.setAadhar(customer.getAadhar());
		account.setStatus("open");
		account.setAmount(0);
		account.setBranchId(1001);
		account.setIfsc("PECU0000123");
	    account.setAccountType("savings");
		accountDao.save(account);
		return account;
		
		}
		else
		{
			if(accountDao.findByAadhar(customer.getAadhar()).get(0).getStatus().equals("closed"))
			{
				account = accountDao.findByAadhar(customer.getAadhar()).get(0);
				account.setStatus("open");
				return account;
			}
			else throw new AadharNotFoundException("aadhar number "+customer.getAadhar()+" already exists");
		}
	}
	

  public boolean deleteAccount(long accountNo)
  {
	  if(isAccountNoExists(accountNo))
	  {
		  
	  List<Account> account = accountDao.findByAccountNo(accountNo);
	  account.get(0).setAccountType("closed");
	  accountDao.save(account.get(0));
	  return true;
	  }
	  else
		  return false;
	  
  }
  public boolean isAccountNoExists(long accountNo)
  {
	  List<Account> account = accountDao.findByAccountNo(accountNo);
		 if(account.isEmpty())
		 {
			
			 return false;
		 }
		 else
		 {
			 if(account.get(0).getStatus().equals("closed"))
				 
				 return false; 
			 else
				 
				 return true;
			 
		 }

  }
  public Account updateAccount(Account account) 
	{
		if (isAccountNoExists(account.getAccountNo()))
			return accountDao.saveAndFlush(account);
		else
			throw new AccountNoNotFoundException("Account with number" + account.getAccountNo() + " does not exists");
	  }
  public Account getAccountByAccountNo(long accountNo)
  {
	  if(isAccountNoExists(accountNo))
	  {
		  return accountDao.findByAccountNo(accountNo).get(0);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  public Customer updateCustomer(Customer customer,long accountNo) 
  {
	  if(accountDao.findByAccountNo(accountNo).isEmpty())
	  {
		  return customerService.updateCustomer(customer);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  public Customer getCustomerDetailsByAccountNumber(long accountNo) 
  {
	  if(isAccountNoExists(accountNo))
	  {
		  Account account = accountDao.findByAccountNo(accountNo).get(0);
		  return customerService.findByAadhar(account.getAadhar()).get(0);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  
}

