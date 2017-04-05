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
@Table(name = "AppStatus")
public class ApplicationStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer Appid;
	private String Status;
	
	@OneToMany(mappedBy="AppStatus",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<LogTime> comments;
	@OneToMany(mappedBy="status",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Contestant> Aid;

	public ApplicationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getAppid() {
		return Appid;
	}
	public void setAppid(Integer appid) {
		Appid = appid;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public List<LogTime> getComments() {
		return comments;
	}

	public void setComments(List<LogTime> comments) {
		this.comments = comments;
	}

	public List<Contestant> getAid() {
		return Aid;
	}

	public void setAid(List<Contestant> aid) {
		Aid = aid;
	}
}
