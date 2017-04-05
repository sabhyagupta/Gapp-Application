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
@Table(name = "Others_value")
public class OtherRequirementValue implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
    private Integer ftid;
	private String otherValue;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private OtherRequirement otherId;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Contestant Aid;
	
	
	public Integer getFtid() {
		return ftid;
	}
	public void setFtid(Integer ftid) {
		this.ftid = ftid;
	}
	public String getOtherValue() {
		return otherValue;
	}
	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
	}
	public OtherRequirement getOtherId() {
		return otherId;
	}
	public void setOtherId(OtherRequirement otherId) {
		this.otherId = otherId;
	}
	public Contestant getAid() {
		return Aid;
	}
	public void setAid(Contestant aid) {
		Aid = aid;
	}
	
	

}
