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
import pl.slaycio.projectzebra2.datamodel.User;
import javax.persistence.OneToOne;


/**
 * The persistent class for the "account_owners" database table.
 * 
 */
@Entity
@Table(name="account_owners")
@NamedQuery(name="AccountOwner.findAll", query="SELECT a FROM AccountOwner a")
public class AccountOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="AccOwnSeq")
    @SequenceGenerator(name="AccOwnSeq",sequenceName="ACC_OWN_SEQ", allocationSize=1)
	private int id;
		
	@Column(name="description", nullable=false, length=2000000000)
	private String description;

	@Column(name="last_name", nullable=false, length=2000000000)
	private String lastName;

	@Column(name="name", nullable=false, length=2000000000)
	private String name;

	@Column(name="owner_type", nullable=false, length=2000000000)
	private String ownerType;

	@Column(name="symbol", nullable=false, length=2000000000)
	private String symbol;
	
	@Column(name="created_by", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="creation_date", nullable=false)
	private String creationDate;

	@OneToMany(mappedBy = "accountOwner")
	private Collection<Account> account;

	@OneToOne(mappedBy = "accountOwner")
	private User user;

	public AccountOwner() {
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

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerType() {
		return this.ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Collection<Account> getAccount() {
	    return account;
	}

	public void setAccount(Collection<Account> param) {
	    this.account = param;
	}

	public User getUser() {
	    return user;
	}

	public void setUser(User param) {
	    this.user = param;
	}

}