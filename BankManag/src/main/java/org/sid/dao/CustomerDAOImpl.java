package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Customer;

public class CustomerDAOImpl implements ICustomerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createCustomer(Customer customer) {
		try {
			em.persist(customer);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		em.merge(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		Query query = em.createQuery("select c from Customer c");
		System.out.println(query.getFirstResult());
		return query.getResultList();
	}

}
