package gapp.model.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.ApplicationStatus;
import gapp.model.Contestant;
import gapp.model.Department;
import gapp.model.OtherRequirement;
import gapp.model.OtherRequirementValue;
import gapp.model.Programs;
import gapp.model.dao.ContestantDao;
@Repository
public class ContestantDaoImpl  implements ContestantDao {
	
	@PersistenceContext
    private EntityManager entityManager;

    
    @Override
    public List<Contestant> getContestant(String DepartmentName,String Term)
    {
String Query = "Select c from Contestant c join c.department d where d.dptname = '" 
				+ DepartmentName + "' and c.term = '" + Term + "'";
		
		return entityManager.createQuery(Query, Contestant.class)
				.getResultList();
    }


	@Override
	public List<Contestant> getContestant(String usern) {
		String Query = "from Contestant where user.email= '"+usern+"'";
		return entityManager.createQuery(Query, Contestant.class).getResultList();
	}


	@Override
	public Contestant getContestantDetails(Integer Aid) {
		String Query = "from Contestant where aid= "+Aid;
				
		return entityManager.createQuery(Query, Contestant.class).getSingleResult();


	}
	@Override
	@Transactional
	public Contestant saveContestant(Contestant Contestant){
		return entityManager.merge(Contestant);
	}


	@Override
	public Contestant getSingleContestantDetails(Integer Aid) {
		String Query = "from Contestant where aid= "+Aid;
		
		return entityManager.createQuery(Query, Contestant.class).getSingleResult();
	}


	@Override
	@Transactional
	public void getudateStatus(ApplicationStatus Status,Integer Aid) {
		entityManager.createQuery( "update " + Contestant.class.getName() + " set status = :status where aid = :aid")
		.setParameter("status", Status)
		.setParameter("aid", Aid)
		.executeUpdate();
		
		
	}
	@Override
	@Transactional
	public void getudateStatusdate(ApplicationStatus Status, Integer Aid) {
		entityManager.createQuery( "update " + Contestant.class.getName() + " set status = :status,dateofsubmission = :datesub" + 
								   " where aid = :aid")
		.setParameter("datesub", new Date())
		.setParameter("status", Status)
		.setParameter("aid", Aid)
		.executeUpdate();
		
	}
	
	@Override
	@Transactional
	public
	void EditApplication(String fname, String lname, Date doB, String citizen, Integer phnumber, Department dept,
			Programs prg, String term, String gender, String transcript, Integer aid,Float gpa) {
		if(transcript.equals("")){
		entityManager.createQuery( "update " + Contestant.class.getName() + " set fname=:fname, lname=:lname, doB=:doB, citizen=:citizen,"
				+ "phnumber=:phnumber,"
				+ "dept=:dept, pid=:pid, term=:term, gender=:gender, gpa=:gpa where aid=:aid")
		.setParameter("fname", fname).setParameter("lname", lname).setParameter("doB", doB).setParameter("citizen", citizen)
		.setParameter("phnumber", phnumber).setParameter("dept", dept).setParameter("pid", prg).setParameter("term", term)
		.setParameter("gender", gender).setParameter("gpa", gpa)
		.setParameter("aid", aid)
		.executeUpdate();
		}else{
			entityManager.createQuery( "update " + Contestant.class.getName() + " set fname=:fname, lname=:lname, doB=:doB, citizen=:citizen,"
					+ "phnumber=:phnumber,transcript = :transcript,"
					+ "dept=:dept, pid=:pid, term=:term, gender=:gender, gpa=:gpa where aid=:aid")
			.setParameter("fname", fname).setParameter("lname", lname).setParameter("doB", doB).setParameter("citizen", citizen)
			.setParameter("phnumber", phnumber).setParameter("dept", dept).setParameter("pid", prg).setParameter("term", term)
			.setParameter("gender", gender).setParameter("gpa", gpa).setParameter("transcript", transcript)
			.setParameter("aid", aid)
			.executeUpdate();
		}
	}


	@Override
	public Contestant getDepartmentotherfield(Department id) {
		return entityManager.createQuery( "from Contestant order by id", Contestant.class ).getSingleResult();
	}


	@Override
	public List<Contestant> getOtherrequirementvalue(OtherRequirementValue othid) {
		return  (List<Contestant>) entityManager.createQuery( "from Contestant order by id", Contestant.class ).getSingleResult();
	}


	@Override
	public String getOldFileName(Integer aid) {
		String Query = "from Contestant where aid= "+aid;
		
		Contestant contestant = entityManager.createQuery(Query, Contestant.class).getSingleResult();
		return contestant.getTranscript();
	}





	
		
	}		
	
	

