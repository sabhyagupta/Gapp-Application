package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.ApplicationStatus;
import gapp.model.Contestant;
import gapp.model.EducationBckgd;
import gapp.model.Programs;
import gapp.model.dao.EducationalBackgroundDao;

@Repository
public class EducationalBackgroundDaoImpl implements EducationalBackgroundDao{
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public List<EducationBckgd> getEducationalDetails(Integer eid) {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from Contestant where eid= "+eid, EducationBckgd.class )
	            .getResultList();	}
	@Override
	public EducationBckgd getSaveAcademic(Integer eid) {
		return  entityManager.createQuery( "from EducationBckgd where eid=:eid",EducationBckgd.class )
				.setParameter("eid",eid).getSingleResult();	
	}
	@Override
	@Transactional
	public EducationBckgd saveEducationBckgd(EducationBckgd EducationBckgd){
		return entityManager.merge(EducationBckgd);
	}
	@Override
	public List<EducationBckgd> getEducationalByaid(Integer aid) {
		return entityManager.createQuery( "select e from EducationBckgd e join e.Aid a where a.aid= "+aid, EducationBckgd.class )
	            .getResultList();
	}
	
	@Override
	@Transactional
	public void Remove(Integer eid) {
		entityManager.createQuery( "delete " + EducationBckgd.class.getName() + " where eid = " + eid).executeUpdate();		
	}
	

}
