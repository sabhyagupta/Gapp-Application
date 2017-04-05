package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Role")

public class role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer Roleid;
	private String RoleName;

	@OneToMany(mappedBy="rolename",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Users> CIN;

	public role() {
		super();
	}

	public List<Users> getCIN() {
		return CIN;
	}

	public void setCIN(List<Users> cIN) {
		CIN = cIN;
	}

	public Integer getRoleid() {
		return Roleid;
	}

	public void setRoleid(Integer roleid) {
		Roleid = roleid;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

}
