package gapp.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "programs")
public class Programs implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer pid;
	private String prgname;
	
	@OneToMany(mappedBy="pid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Contestant> Aid;
	
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department dptid;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPrgname() {
		return prgname;
	}
	public void setPrgname(String prgname) {
		this.prgname = prgname;
	}
	public Department getDptid() {
		return dptid;
	}
	public void setDptid(Department dptid) {
		this.dptid = dptid;
	}

}
