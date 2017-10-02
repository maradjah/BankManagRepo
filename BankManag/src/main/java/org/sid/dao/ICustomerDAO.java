package org.sid.dao;

import java.util.List;

import org.sid.entities.Customer;

public interface ICustomerDAO {
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
}
