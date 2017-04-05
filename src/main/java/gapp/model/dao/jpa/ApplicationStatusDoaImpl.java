package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.ApplicationStatus;
import gapp.model.Users;
import gapp.model.role;
import gapp.model.dao.ApplicationStatusDao;
import gapp.model.dao.RoleDao;

@Repository
public class ApplicationStatusDoaImpl implements ApplicationStatusDao{
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public ApplicationStatus getApplicationStatus(String Status) {
		return  entityManager.createQuery( "from ApplicationStatus where Status = :status",ApplicationStatus.class )
				.setParameter("status",Status).getSingleResult();	
	}

}
