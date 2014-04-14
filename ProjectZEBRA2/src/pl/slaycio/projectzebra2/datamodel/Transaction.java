package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the "transactions" database table.
 * 
 */
@Entity
@Table(name="\"transactions\"")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"category_id\"", nullable=false)
	private int categoryId;

	@Column(name="\"created_by\"", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="\"creation_date\"", nullable=false)
	private String creationDate;

	@Column(name="\"from_account_id\"", nullable=false)
	private int fromAccountId;

	@Column(name="\"from_amount\"", nullable=false, length=2000000000)
	private String fromAmount;

	@Column(name="\"from_currency\"", nullable=false, length=2000000000)
	private String fromCurrency;

	@Id
	private int id;

	@Column(name="\"table_exchange_rate\"", nullable=false, length=2000000000)
	private String tableExchangeRate;

	@Column(name="\"to_account_id\"", nullable=false)
	private int toAccountId;

	@Column(name="\"to_amount\"", nullable=false, length=2000000000)
	private String toAmount;

	@Column(name="\"to_currency\"", nullable=false, length=2000000000)
	private String toCurrency;

	@Column(name="\"transaction_date\"", nullable=false)
	private String transactionDate;

	@Column(name="\"user_exchange_rate\"", nullable=false, length=2000000000)
	private String userExchangeRate;

	public Transaction() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public int getFromAccountId() {
		return this.fromAccountId;
	}

	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getFromAmount() {
		return this.fromAmount;
	}

	public void setFromAmount(String fromAmount) {
		this.fromAmount = fromAmount;
	}

	public String getFromCurrency() {
		return this.fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableExchangeRate() {
		return this.tableExchangeRate;
	}

	public void setTableExchangeRate(String tableExchangeRate) {
		this.tableExchangeRate = tableExchangeRate;
	}

	public int getToAccountId() {
		return this.toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	public String getToAmount() {
		return this.toAmount;
	}

	public void setToAmount(String toAmount) {
		this.toAmount = toAmount;
	}

	public String getToCurrency() {
		return this.toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUserExchangeRate() {
		return this.userExchangeRate;
	}

	public void setUserExchangeRate(String userExchangeRate) {
		this.userExchangeRate = userExchangeRate;
	}

}