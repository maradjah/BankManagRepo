package org.sid.metier;

import java.util.List;

import org.sid.dao.ICustomerDAO;
import org.sid.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerMetierImpl implements ICustomerMetier {

	private ICustomerDAO daoc;

	public ICustomerDAO getDaoc() {
		return daoc;
	}

	public void setDaoc(ICustomerDAO daoc) {
		this.daoc = daoc;
	}

	@Override
	public void createCustomer(Customer customer) {
		daoc.createCustomer(customer);

	}

	@Override
	public void updateCustomer(Customer customer) {
		daoc.updateCustomer(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return daoc.getAllCustomers();
	}

}
