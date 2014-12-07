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


/**
 * The persistent class for the "account_owners" database table.
 * 
 */
@Entity
@Table(name="account_types")
@NamedQuery(name="AccountType.findAll", query="SELECT a FROM AccountType a")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="AccountTypeSeq")
    @SequenceGenerator(name="AccountTypeSeq",sequenceName="ACC_TYPE_SEQ", allocationSize=1)
	private int id;
		
	@Column(name="description", nullable=false, length=2000000000)
	private String description;
		
	@Column(name="created_by", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="creation_date", nullable=false)
	private String creationDate;

	@OneToMany(mappedBy = "accountType")
	private Collection<Account> accountsOfThisType;
	
	
	public AccountType() {
	}
	
		

	public AccountType(String name) {
		super();
		this.description = "opissss";
		this.createdBy = "mnie";
		this.creationDate = "denjudejt";
		
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

	
}