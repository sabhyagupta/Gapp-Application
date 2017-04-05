package gapp.model.dao;
import java.util.List;

import gapp.model.Contestant;
import gapp.model.Department;
import gapp.model.OtherRequirement;
import gapp.model.Users;
public interface DepartmentDao {
	
	    Department getDepartment(String dptname );
	    Department getDepartment(Integer id );
	    List<Department> getDepartment();
	    Department saveDepartment(Department Department);
	    void updateDepartment(String dptname,Integer dptid);
	    Department getDepartmentapplication(OtherRequirement id );

	    



}
