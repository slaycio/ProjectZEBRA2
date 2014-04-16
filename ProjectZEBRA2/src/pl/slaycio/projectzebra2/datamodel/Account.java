package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pl.slaycio.projectzebra2.datamodel.FinancialInstitution;



/**
 * The persistent class for the "accounts" database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="AccSeq")
    @SequenceGenerator(name="AccSeq",sequenceName="ACC_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="account_type", nullable=false, length=2000000000)
	private String accountType;

	@Column(name="balance", nullable=false, length=2000000000)
	private String balance;
	
	@Column(name="currency", nullable=false, length=2000000000)
	private String currency;

	@Column(name="description", nullable=false, length=2000000000)
	private String description;

	@Column(name="name", nullable=false, length=2000000000)
	private String name;

	@Column(name="symbol", nullable=false, length=2000000000)
	private String symbol;
	
	@Column(name="created_by", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="creation_date", nullable=false)
	private String creationDate;

	@ManyToOne
	@JoinColumn(name = "account_owners_id", referencedColumnName = "id")
	private AccountOwner accountOwner;

	@OneToMany(mappedBy = "toAccount")
	private Collection<Transaction> toTransactions;

	@OneToMany(mappedBy = "fromAccount")
	private Collection<Transaction> fromTransactions;

	@ManyToOne
	private Account parentAccount;

	@OneToMany(mappedBy = "parentAccount")
	private Collection<Account> subAccounts	;

	@ManyToOne
	private FinancialInstitution financialInstitution;

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

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public AccountOwner getAccountOwner() {
	    return accountOwner;
	}

	public void setAccountOwner(AccountOwner param) {
	    this.accountOwner = param;
	}

	public Collection<Transaction> getToTransactions() {
	    return toTransactions;
	}

	public void setToTransactions(Collection<Transaction> param) {
	    this.toTransactions = param;
	}

	public Collection<Transaction> getFromTransactions() {
	    return fromTransactions;
	}

	public void setFromTransactions(Collection<Transaction> param) {
	    this.fromTransactions = param;
	}

	public Account getAccount() {
	    return parentAccount;
	}

	public void setAccount(Account param) {
	    this.parentAccount = param;
	}

	public Collection<Account> getSubAccounts() {
	    return subAccounts;
	}

	public void setSubAccounts(Collection<Account> param) {
	    this.subAccounts = param;
	}

	public FinancialInstitution getFinancialInstitution() {
	    return financialInstitution;
	}

	public void setFinancialInstitution(FinancialInstitution param) {
	    this.financialInstitution = param;
	}

	
}