package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountID;
	private String description;
	private double balance;
	private Date creationDate;

	@ManyToMany(mappedBy = "accounts")
	private Collection<Customer> owners;

	@OneToMany(mappedBy = "account")
	private Collection<Tx> transactions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Tx> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Tx> transactions) {
		this.transactions = transactions;
	}

	public Account(String description, double balance, Date creationDate) {
		super();
		this.description = description;
		this.balance = balance;
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Collection<Customer> getOwners() {
		return owners;
	}

	public void setOwners(Collection<Customer> owners) {
		this.owners = owners;
	}

}
