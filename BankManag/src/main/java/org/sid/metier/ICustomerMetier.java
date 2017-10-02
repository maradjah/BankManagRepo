package org.sid.metier;

import java.util.List;

import org.sid.entities.Customer;

public interface ICustomerMetier {
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}
