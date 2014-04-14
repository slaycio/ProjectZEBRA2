package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the "users" database table.
 * 
 */
@Entity
@Table(name="\"users\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"created_by\"", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="\"creation_date\"", nullable=false)
	private String creationDate;

	@Id
	private int id;

	@Column(name="\"owner\"", nullable=false)
	private int owner;

	@Column(name="\"password\"", nullable=false, length=2000000000)
	private String password;

	@Column(name="\"user\"", nullable=false, length=2000000000)
	private String user;

	public User() {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwner() {
		return this.owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
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

}