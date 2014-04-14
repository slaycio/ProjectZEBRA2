package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the "transaction_categories" database table.
 * 
 */
@Entity
@Table(name="\"transaction_categories\"")
@NamedQuery(name="TransactionCategory.findAll", query="SELECT t FROM TransactionCategory t")
public class TransactionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"created_by\"", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="\"creation_date\"", nullable=false)
	private String creationDate;

	@Column(name="\"description\"", nullable=false, length=2000000000)
	private String description;

	@Id
	private int id;

	@Column(name="\"master_category_id\"", nullable=false)
	private int masterCategoryId;

	@Column(name="\"name\"", nullable=false, length=2000000000)
	private String name;

	public TransactionCategory() {
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

	public int getMasterCategoryId() {
		return this.masterCategoryId;
	}

	public void setMasterCategoryId(int masterCategoryId) {
		this.masterCategoryId = masterCategoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}