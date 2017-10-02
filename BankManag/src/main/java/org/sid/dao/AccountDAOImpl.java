package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Account;
import org.sid.entities.Customer;

public class AccountDAOImpl implements IAccountDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createAccount(Account account) {
		try {
			em.persist(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAccount(Account account) {
		try {
			em.remove(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomertoAccount(Customer customer, Account account) {

		// account.getOwners().add(customer);
		// em.merge(account);
	}

	@Override
	public void removeCustomerFromAccount(Customer customer, Account account) {
		// account.getOwners().remove(customer);
		// em.merge(account);

	}

	@Override
	public List<Account> getAccountsOfCustomer(Customer customer) {
		List<Account> CustomerAccounts = (List<Account>) customer.getAccounts();
		return CustomerAccounts;
	}

	@Override
	public List<Account> getAllAccounts() {
		Query query = em.createQuery("select ac from Account ac");
		return query.getResultList();
	}

	@Override
	public Account getAccountById(Long accountId) {
		Query query = em
				.createQuery("select ac from Account ac where ac.accountId =:x");
		query.setParameter("x", accountId);
		return (Account) query.getSingleResult();
	}

}
