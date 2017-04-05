package gapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user1")	
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer userid;
	private String Fname;
	private String Lname;
	private String email;
	private String password;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private role rolename;

	public Users() {
		super();

	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public role getRolename() {
		return rolename;
	}

	public void setRolename(role rolename) {
		this.rolename = rolename;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	
}

