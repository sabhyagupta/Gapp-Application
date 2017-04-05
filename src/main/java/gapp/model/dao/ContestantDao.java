package gapp.model.dao;
import java.util.Date;
import java.util.List;

import gapp.model.ApplicationStatus;
import gapp.model.Contestant;
import gapp.model.Department;
import gapp.model.OtherRequirement;
import gapp.model.OtherRequirementValue;
import gapp.model.Programs;

public interface ContestantDao {
	    List<Contestant> getContestant(String DepartmentName,String Term);
	    List<Contestant> getContestant(String usern);
	    Contestant getContestantDetails(Integer Aid);
	    Contestant saveContestant(Contestant Contestant);
	    Contestant getSingleContestantDetails(Integer Aid);
	    void getudateStatus(ApplicationStatus Status,Integer Aid);
	    void getudateStatusdate(ApplicationStatus Status,Integer Aid);
		void EditApplication(String fname, String lname, Date doB, String citizen, Integer phnumber, Department dept,
				Programs prg, String term, String gender, String transcript, Integer aid,Float gpa);
		Contestant getDepartmentotherfield(Department id);
	    List<Contestant> getOtherrequirementvalue(OtherRequirementValue othid);
	    
	    String getOldFileName(Integer aid);

} 
