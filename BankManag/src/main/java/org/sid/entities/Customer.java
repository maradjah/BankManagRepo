package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3809679211424599252L;

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "zip")
	private String zip;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "CUST_ACCS", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "account_id") })
	private List<Account> accounts = new ArrayList<Account>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String lastName, String firstName, String street,
			String city, String zip, String phone, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	public void addAccount(Account account) {
		addAccount(account, true);
	}

	void addAccount(Account account, boolean set) {
		if (account != null) {
			if (getAccounts().contains(account)) {
				getAccounts().set(getAccounts().indexOf(account), account);
			} else {
				getAccounts().add(account);
			}
			if (set) {
				account.setCustomer(this, false);
			}
		}
	}

	public void removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCustomer(null);
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	// public Long getCustomerID() {
	// return customerId;
	// }
	//
	// public void setCustomerID(Long customerID) {
	// this.customerId = customerID;
	// }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
