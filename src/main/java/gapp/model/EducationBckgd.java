package gapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Educationbg")
public class EducationBckgd implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer eid;
	private String degree;
	private String clgName;
	private String yoP;
	private String major;
	private String degreename;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Contestant Aid;
    
	public EducationBckgd() {
		super();
	}
	
	public String getYoP() {
		return yoP;
	}
	public void setYoP(String yoP) {
		this.yoP = yoP;
	}
	public String getDegreename() {
		return degreename;
	}
	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public Contestant getAid() {
		return Aid;
	}

	public void setAid(Contestant aid) {
		Aid = aid;
	}
	
}
