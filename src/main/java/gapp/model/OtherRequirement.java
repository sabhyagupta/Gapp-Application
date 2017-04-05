package gapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Others")
public class OtherRequirement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nameField;
	private String typeField;
	private Boolean required;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department department;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Contestant Aid;
	@OneToMany(mappedBy="otherId",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<OtherRequirementValue> otherRequirementValues;
	
	public OtherRequirement() {
		super();
		otherRequirementValues = new ArrayList<OtherRequirementValue>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	public String getTypeField() {
		return typeField;
	}

	public void setTypeField(String typeField) {
		this.typeField = typeField;
	}

	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Contestant getAid() {
		return Aid;
	}
	public void setAid(Contestant aid) {
		Aid = aid;
	}
	public List<OtherRequirementValue> getOtherRequirementValues() {
		return otherRequirementValues;
	}
	public void setOtherRequirementValues(List<OtherRequirementValue> otherRequirementValues) {
		this.otherRequirementValues = otherRequirementValues;
	}
	
}
