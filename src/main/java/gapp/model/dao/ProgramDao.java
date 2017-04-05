package gapp.model.dao;

import java.util.List;

import gapp.model.Programs;
import gapp.model.Users;
import gapp.model.role;

public interface ProgramDao {
	  Programs getProgram(Integer id );

	    List<Programs> getProgram1(Integer dptid);
	    List<Programs> getProgram(String dptname);
	    Programs getProgram(Integer dptid,String prgname);
	    Programs saveProgram(Programs prg);
	    
	    void Remove(Integer id);
	    
}
