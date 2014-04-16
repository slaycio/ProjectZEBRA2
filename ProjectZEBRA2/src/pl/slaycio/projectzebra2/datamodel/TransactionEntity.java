package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pl.slaycio.projectzebra2.datamodel.FinancialInstitution;
import javax.persistence.OneToOne;

/**
 * The persistent class for the "transaction_categories" database table.
 * 
 */
@Entity
@Table(name = "transaction_entities")
@NamedQuery(name = "TransactionCategory.findAll", query = "SELECT t FROM TransactionEntity t")
public class TransactionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "TrxCatSeq")
	@SequenceGenerator(name = "TrxCatSeq", sequenceName = "TRX_CAT_SEQ", allocationSize = 1)
	private int id;

	@Column(name = "description", nullable = false, length = 2000000000)
	private String description;

	@Column(name = "name", nullable = false, length = 2000000000)
	private String name;

	@Column(name = "created_by", nullable = false, length = 2000000000)
	private String createdBy;

	@Column(name = "creation_date", nullable = false)
	private String creationDate;

	@OneToMany(mappedBy = "transactionEntity")
	private Collection<Transaction> transactions;

	@OneToOne(mappedBy = "transactionEntity")
	private FinancialInstitution financialInstitution;

	public TransactionEntity() {
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

	public Collection<Transaction> getTransactions() {
	    return transactions;
	}

	public void setTransactions(Collection<Transaction> param) {
	    this.transactions = param;
	}

	public FinancialInstitution getFinancialInstitution() {
	    return financialInstitution;
	}

	public void setFinancialInstitution(FinancialInstitution param) {
	    this.financialInstitution = param;
	}

}