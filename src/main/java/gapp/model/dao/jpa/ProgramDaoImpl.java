package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.OtherRequirement;
import gapp.model.Programs;
import gapp.model.Users;
import gapp.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao{
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public Programs getProgram(Integer id) {
		return null;
	}
	@Override
	public List<Programs> getProgram1(Integer dptid) {
		return entityManager.createQuery( "from Programs where pid=:dptid",Programs.class )
				.setParameter("dptid", dptid)
				.getResultList();	
		}
	
	@Override
	public List<Programs> getProgram(String dptname) {
		return entityManager.createQuery( "select p from Programs p join p.dptid d " + 
				  "where d.dptname = :dptname", Programs.class )
			.setParameter("dptname", dptname)
			.getResultList();
	}
	@Override
	public Programs getProgram(Integer dptid, String prgname) {
		return entityManager.createQuery( "select p from Programs p join p.dptid d " + 
				  "where d.dptid = :dptid and p.prgname = :prgname", Programs.class )
			.setParameter("dptid", dptid)
			.setParameter("prgname", prgname)
			.getSingleResult();
	}
	
	@Override
	@Transactional
	public Programs saveProgram(Programs prg) {
		return entityManager.merge(prg);
	}
	
	@Override
	@Transactional
	public void Remove(Integer id) {
		entityManager.createQuery( "delete " + Programs.class.getName() + " where pid = " + id).executeUpdate();
	}
	
	
}
