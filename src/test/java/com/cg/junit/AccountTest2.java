package com.cg.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.Account;
import com.cg.dto.Customer;
import com.cg.service.AccountService;
import com.cg.service.CustomerService;
@SpringBootTest
class AccountTest2 {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;

	@Test
	void updateCustomerTest()
	{
		String str = "1999-06-22";
		Date date = Date.valueOf(str);
		Customer customer = new Customer(123456789018L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
		Account account=accountService.addAccount(customer);
		
		Customer customer1 = new Customer(123456789018L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
	Customer customer2 = accountService.updateCustomer(customer1, 1000000004L);
		assertEquals(123456789018L,customer2.getAadhar());
	}

	@Test
	void addCustomerTest()
	{
		String str = "1999-06-22";
		Date date = Date.valueOf(str);
		Customer customer = new Customer(123456789019L,"chandu",9963673280L,"ABCDEFGH",date,"NArapally","telangana","hyderabad","india",501301,"male");
		Account account=accountService.addAccount(customer);
		
		List<Customer> custList = customerService.findByAadhar(customer.getAadhar());
		assertEquals(123456789019L,custList.get(0).getAadhar());
	}


}
