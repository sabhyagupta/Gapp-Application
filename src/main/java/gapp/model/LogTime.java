package gapp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "logTime")
public class LogTime implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer Lid;
	private Date Ldate;
	private String Comment;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private ApplicationStatus AppStatus;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Contestant Aid;	

	public LogTime() {
		super();
	}
	public Contestant getAid() {
		return Aid;
	}

	public void setAid(Contestant aid) {
		Aid = aid;
	}
	public Integer getLid() {
		return Lid;
	}
	public void setLid(Integer lid) {
		Lid = lid;
	}
	public ApplicationStatus getAppStatus() {
		return AppStatus;
	}
	public void setAppStatus(ApplicationStatus appStatus) {
		AppStatus = appStatus;
	}
	
	public Date getLdate() {
		return Ldate;
	}
	public void setLdate(Date ldate) {
		Ldate = ldate;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
}
