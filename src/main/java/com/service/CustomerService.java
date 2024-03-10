package com.service;

import java.util.List;

import com.model.Booking;
import com.model.Customer;

public interface CustomerService {
	
    public Customer addCustomer(Customer c);
	
	public void deleteCustomer(long customerId);
	
	public Customer updateCustomer(Customer cs);
	
	public Customer getOneCustomer(long customerId);
	
	public List<Customer> getAll();
	
//	public List<Customer> findByEmail(String email);
	
	public Customer registerCustomer(Customer customer);
	
	public Customer loginCustomer(String email, String password);

	public Customer authenticateCustomer(String email, String password);

}
