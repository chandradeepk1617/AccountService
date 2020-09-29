package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerRepository;
import com.cg.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerRepository customerDao;
@Autowired
private AccountService accountService;
public void addCustomer(Customer customer)
{
	customerDao.save(customer);
}
public List<Customer> findByAadhar(long aadhar)
{
	return customerDao.findByAadhar(aadhar);
}
@Transactional
public Customer updateCustomer(Customer customer)
{
	return customerDao.saveAndFlush(customer);
}
public boolean isAadharNoExists(long aadhar)
{
	if(customerDao.findByAadhar(aadhar).size()>0)
		return true;
	else
		return false;
}


}
