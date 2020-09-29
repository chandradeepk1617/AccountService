package com.cg.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.Account;
import com.cg.dto.Customer;
import com.cg.service.AccountService;
import com.cg.service.CustomerService;
@SpringBootTest
class AccountTest1 {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;

	@Test
	void isAccountNoEistsTest()
	{
		String str = "1999-06-22";
		Date date = Date.valueOf(str);
		Customer customer = new Customer(123456789018L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
		Account account=accountService.addAccount(customer);
		boolean flag = accountService.isAccountNoExists(1000000005);
		assertEquals(true,flag);
	}
	@Test
	void updateAccountTest()
	{
		String str = "1999-06-22";
		Date date = Date.valueOf(str);
		Customer customer = new Customer(123456789017L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
		Account account=accountService.addAccount(customer);
		
		Account account1 = new Account(1000000004,123456789017L,100,"jfs","sds","sds",100001);
		Account account2 = accountService.updateAccount(account);
		assertEquals(1000000004,account2.getAccountNo());
	}
	
}
