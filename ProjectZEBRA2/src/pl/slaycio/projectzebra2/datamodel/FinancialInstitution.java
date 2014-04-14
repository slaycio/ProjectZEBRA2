package pl.slaycio.projectzebra2.datamodel;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the "financial_institutions" database table.
 * 
 */
@Entity
@Table(name="\"financial_institutions\"")
@NamedQuery(name="FinancialInstitution.findAll", query="SELECT f FROM FinancialInstitution f")
public class FinancialInstitution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"created_by\"", nullable=false, length=2000000000)
	private String createdBy;

	@Column(name="\"creation_date\"", nullable=false)
	private String creationDate;

	@Column(name="\"description\"", nullable=false, length=2000000000)
	private String description;

	@Id
	private int id;

	@Column(name="\"institution_type\"", nullable=false, length=2000000000)
	private String institutionType;

	@Column(name="\"official_name\"", nullable=false, length=2000000000)
	private String officialName;

	@Column(name="\"symbol\"", nullable=false, length=2000000000)
	private String symbol;

	public FinancialInstitution() {
	}
	
	public FinancialInstitution(String officialName,
			String description, String institutionType) {

		this.officialName = officialName;
		this.description = description;
		this.institutionType = institutionType;
		this.symbol = "DDP";
		this.creationDate = "duupaa";
		this.createdBy = "currentLoggedUser";
		
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

	public String getInstitutionType() {
		return this.institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getOfficialName() {
		return this.officialName;
	}

	public void setOfficialName(String officialName) {
		this.officialName = officialName;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}