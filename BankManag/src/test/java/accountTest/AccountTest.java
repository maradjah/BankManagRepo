package accountTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sid.entities.Account;
import org.sid.entities.Customer;
import org.sid.metier.IAccountMetier;
import org.sid.metier.ICustomerMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
	private IAccountMetier accountMetier;
	private ICustomerMetier customerMetier;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		accountMetier = (IAccountMetier) context.getBean("metier");
		customerMetier = (ICustomerMetier) context.getBean("metierc");
	}

	// @Test
	// public void test1() {
	// List<Account> list1 = accountMetier.getAllAccounts();
	// Account acc = new Account("Compte Epargne", 400, new Date());
	// Account acc2 = new Account("Compte Courant", 5000, new Date());
	// accountMetier.createAccount(acc);
	// accountMetier.createAccount(acc2);
	// List<Account> list2 = accountMetier.getAllAccounts();
	// assertTrue(list1.size() + 2 == list2.size());
	// }
	//
	// @Test
	// public void test2() {
	// List<Customer> list1 = customerMetier.getAllCustomers();
	// Customer cust = new Customer("erradja", "amine", "street", "kenitra",
	// "451", "06", "mail.com");
	// Customer cust2 = new Customer("Erradja", "fadwa", "street", "kenitra",
	// "57000", "06", "@fadwa.com");
	// customerMetier.createCustomer(cust);
	// customerMetier.createCustomer(cust2);
	// List<Customer> list2 = customerMetier.getAllCustomers();
	// assertTrue(list1.size() + 2 == list2.size());
	// }

	@Test
	public void test3() {
		Account account = new Account("Epargne", 400, new Date());
		accountMetier.createAccount(account);
		Customer cust1 = new Customer("Erradja", "Marwane", "rue des plats",
				"clermont", "6300", "06", "marwane@gmail.com");
		cust1.addAccount(account);
		customerMetier.createCustomer(cust1);
		Customer cust2 = new Customer("Erradja", "Amine", "rue 22", "Lille",
				"5700", "06", "amine@gmail.com");

		cust2.addAccount(account);
		customerMetier.createCustomer(cust2);

		Account account2 = new Account("Assurance", 6000, new Date());
		accountMetier.createAccount(account2);
		cust2.addAccount(account2);
		customerMetier.updateCustomer(cust2);

	}

	// @Test
	// public void test4() {
	//
	// Customer cust2 = new Customer("Erradja", "Amine", "rue 22", "Lille",
	// "5700", "06", "amine@gmail.com");
	// Account account = accountMetier.getAccountById(1L);
	// cust2.addAccount(account);
	// customerMetier.createCustomer(cust2);
	//
	// }

	/* test getAccountById */
	// @Test
	// public void test4() {
	// double balance = 400L;
	// Account account = accountMetier.getAccountById(1L);
	// System.out.println(account.getBalance());
	// assertTrue((account != null));
	// assertTrue(balance == account.getBalance());
	//
	// }
}
