package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pl.slaycio.projectzebra2.datamodel.AccountOwner;
import javax.persistence.OneToOne;


/**
 * The persistent class for the "users" database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(generator="UserSeq")
    @SequenceGenerator(name="UserSeq",sequenceName="USER_SEQ", allocationSize=1)
	private int id;

	@Column(name="password", nullable=false, length=2000000000)
	private String password;

	@Column(name="user", nullable=false, length=2000000000)
	private String user;
	
	@Column(name="created_by", nullable=false, length=2000000000)
	private String createdBy;
    	
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name="creation_date", nullable=false)
	private java.util.Date creationDate;


	@OneToOne
	private AccountOwner accountOwner;


	
	

	public User() {
	}
		
	public User(String inUser, String inPassword, AccountOwner inown) {
		
		super();
		this.user = inUser;
		this.password= inPassword;
		this.createdBy = "currentLoggedUser";
		this.creationDate = new Date();
		this.accountOwner = inown;
	
				
		
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public AccountOwner getAccountOwner() {
	    return accountOwner;
	}

	public void setAccountOwner(AccountOwner param) {
	    this.accountOwner = param;
	}

	

}