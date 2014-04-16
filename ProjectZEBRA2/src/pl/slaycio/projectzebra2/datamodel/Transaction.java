package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pl.slaycio.projectzebra2.datamodel.TransactionEntity;


/**
 * The persistent class for the "transactions" database table.
 * 
 */
@Entity
@Table(name="transactions")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="TrxSeq")
    @SequenceGenerator(name="TrxSeq",sequenceName="TRX_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="category_id", nullable=false)
	private int categoryID;
	
	@Column(name="from_amount", nullable=false, length=2000000000)
	private String fromAmount;

	@Column(name="to_amount", nullable=false, length=2000000000)
	private String toAmount;

	@Column(name="transaction_date", nullable=false)
	private String transactionDate;

	@Column(name="table_exchange_rate", nullable=false, length=2000000000)
	private String tableExchangeRate;
	
	@Column(name="user_exchange_rate", nullable=false, length=2000000000)
	private String userExchangeRate;
	
	@Column(name="created_by", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="creation_date", nullable=false)
	private String creationDate;

	@ManyToOne
	@JoinColumn(name = "to_account")
	private Account toAccount;

	@ManyToOne
	@JoinColumn(name = "from_account")
	private Account fromAccount;

	@ManyToOne
	@JoinColumn(name = "TransactionEntity_id", referencedColumnName = "id")
	private TransactionEntity transactionEntity;

	public Transaction() {
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryId) {
		this.categoryID = categoryId;
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

	public String getFromAmount() {
		return this.fromAmount;
	}

	public void setFromAmount(String fromAmount) {
		this.fromAmount = fromAmount;
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

	public String getToAmount() {
		return this.toAmount;
	}

	public void setToAmount(String toAmount) {
		this.toAmount = toAmount;
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

	public Account getToAccount() {
	    return toAccount;
	}

	public void setToAccount(Account param) {
	    this.toAccount = param;
	}

	public Account getFromAccount() {
	    return fromAccount;
	}

	public void setFromAccount(Account param) {
	    this.fromAccount = param;
	}

	public TransactionEntity getTransactionEntity() {
	    return transactionEntity;
	}

	public void setTransactionEntity(TransactionEntity param) {
	    this.transactionEntity = param;
	}

	
}