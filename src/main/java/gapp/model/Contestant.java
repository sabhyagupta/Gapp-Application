package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Applications")
public class Contestant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer aid;
	private Integer CIN;
	private String term;
	private String fname;
	private String lname;
	private Integer phnumber;
	private String gender;
	private Date doB;
	private String citizen;
	private float gpa;
	private String transcript;
	private Date dateofsubmission;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Users user;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department dept;
	@OneToMany(mappedBy="Aid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<LogTime> comment;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private ApplicationStatus status;
	@OneToMany(mappedBy="Aid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<EducationBckgd> education;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Programs pid;
	@OneToMany(mappedBy="Aid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<OtherRequirementValue> otherRequirementValues;
	@OneToMany(mappedBy="Aid",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<OtherRequirement> nameField;
	
	

	public Contestant() {
		super();
		education = new ArrayList<EducationBckgd>();
		nameField= new ArrayList<OtherRequirement>();
		otherRequirementValues = new ArrayList<OtherRequirementValue>();
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getCIN() {
		return CIN;
	}

	public void setCIN(Integer cIN) {
		CIN = cIN;
	}
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(Integer phnumber) {
		this.phnumber = phnumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDoB() {
		return doB;
	}

	public void setDoB(Date doB) {
		this.doB = doB;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	
	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public Date getDateofsubmission() {
		return dateofsubmission;
	}

	public void setDateofsubmission(Date dateofsubmission) {
		this.dateofsubmission = dateofsubmission;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<LogTime> getComment() {
		return comment;
	}

	public void setComment(List<LogTime> comment) {
		this.comment = comment;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public List<EducationBckgd> getEducation() {
		return education;
	}

	public void setEducation(List<EducationBckgd> education) {
		this.education = education;
	}

	public Programs getPid() {
		return pid;
	}

	public void setPid(Programs pid) {
		this.pid = pid;
	}

	public List<OtherRequirementValue> getOtherRequirementValues() {
		return otherRequirementValues;
	}

	public void setOtherRequirementValues(List<OtherRequirementValue> otherRequirementValues) {
		this.otherRequirementValues = otherRequirementValues;
	}

	public List<OtherRequirement> getNameField() {
		return nameField;
	}

	public void setNameField(List<OtherRequirement> nameField) {
		nameField = nameField;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
