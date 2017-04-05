package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.EducationBckgd;
import gapp.model.OtherRequirement;
import gapp.model.OtherRequirementValue;
import gapp.model.Programs;
import gapp.model.dao.OtherFieldDao;

@Repository
public class OtherRequirementDaoimpl  implements OtherFieldDao{
 
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public List<OtherRequirement> getOtherRequirement(String dptname) {
		return entityManager.createQuery( "select o from OtherRequirement o join o.department d " + 
										  "where d.dptname = :dptname", OtherRequirement.class )
				.setParameter("dptname", dptname)
	            .getResultList();
	}
	    @Override
		@Transactional
		public OtherRequirement saveOtherRequirement(OtherRequirement other) {
			return entityManager.merge(other);
		}
	
	
	@Override
	@Transactional
	public void OtherRequirementRemove(Integer id) {
		entityManager.createQuery( "update " + OtherRequirementValue.class.getName() 
								 + " set otherId = null where otherId.id = :id")
		 			 .setParameter("id", id).executeUpdate();
		entityManager.createQuery( "delete " + OtherRequirement.class.getName() + " where id = " + id).executeUpdate();		
	}
	@Override
	public List<OtherRequirement> getOtherRequirementdetails() {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from OtherRequirement order by id", OtherRequirement.class )
	            .getResultList();	
	}
	@Override
	public OtherRequirement getOtherRequirement(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from OtherRequirement where id=:id", OtherRequirement.class )
				.setParameter("id", id)
				.getSingleResult();
		}	
	}


