package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")

public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer dptid;
	private String dptname;
	
    @OneToMany(mappedBy="department",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	 List<OtherRequirement> NameField;
    
    @OneToMany(mappedBy="dptid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	List<Programs> pid;
	
    @OneToMany(mappedBy="dept",cascade={CascadeType.PERSIST, CascadeType.MERGE})
    List<Contestant> Aid;
    
    
    public List<Contestant> getAid() {
		return Aid;
	}

	public void setAid(List<Contestant> aid) {
		Aid = aid;
	}

	public List<OtherRequirement> getNameField() {
		return NameField;
	}

	public void setNameField(List<OtherRequirement> nameField) {
		NameField = nameField;
	}

	public Department() {
		super();
	}

	public Integer getDptid() {
		return dptid;
	}
	public void setDptid(Integer dptid) {
		this.dptid = dptid;
	}
	public String getDptname() {
		return dptname;
	}
	public void setDptname(String dptname) {
		this.dptname = dptname;
	}

	public List<Programs> getPid() {
		return pid;
	}

	public void setPid(List<Programs> pid) {
		this.pid = pid;
	}
	
}
