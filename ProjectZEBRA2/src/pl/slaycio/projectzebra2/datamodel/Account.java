package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the "accounts" database table.
 * 
 */
@Entity
@Table(name="\"accounts\"")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"account_type\"", nullable=false, length=2000000000)
	private String accountType;

	@Column(name="\"balance\"", nullable=false, length=2000000000)
	private String balance;

	@Column(name="\"created_by\"", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="\"creation_date\"", nullable=false)
	private String creationDate;

	@Column(name="\"currency\"", nullable=false, length=2000000000)
	private String currency;

	@Column(name="\"description\"", nullable=false, length=2000000000)
	private String description;

	@Column(name="\"financial_institution\"", nullable=false)
	private int financialInstitution;

	@Id
	private int id;

	@Column(name="\"name\"", nullable=false, length=2000000000)
	private String name;

	@Column(name="\"owner\"", nullable=false)
	private int owner;

	@Column(name="\"symbol\"", nullable=false, length=2000000000)
	private String symbol;

	public Account() {
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalance() {
		return this.balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFinancialInstitution() {
		return this.financialInstitution;
	}

	public void setFinancialInstitution(int financialInstitution) {
		this.financialInstitution = financialInstitution;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwner() {
		return this.owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}