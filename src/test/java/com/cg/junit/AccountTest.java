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
class AccountTest {
@Autowired
private AccountService accountService;
@Autowired
private CustomerService customerService;
@Test
void addAccountTest()
{
	String str = "1999-06-22";
	Date date = Date.valueOf(str);
	boolean flag;
	Customer customer = new Customer(123456789016L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
Account account=accountService.addAccount(customer);

assertEquals(1000000005,account.getAccountNo());

}
@Test
void deleteAccountTest()
{

	String str = "1999-06-22";
	Date date = Date.valueOf(str);
	Customer customer = new Customer(123456789015L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
	Account account=accountService.addAccount(customer);
	boolean flag = accountService.deleteAccount(1000000004);
	assertEquals(true,flag);
}

}
