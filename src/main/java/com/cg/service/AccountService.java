package com.cg.service;



import com.cg.dto.Account;
import com.cg.dto.Customer;


public interface AccountService {
	public Account addAccount(Customer customer);
	public boolean deleteAccount(long accountNo);
	public boolean isAccountNoExists(long accountNo);
	public Account updateAccount(Account account);
	public Account getAccountByAccountNo(long accountNo);
	 public Customer updateCustomer(Customer customer,long accountNo);
	 public Customer getCustomerDetailsByAccountNumber(long accountNo);

}
