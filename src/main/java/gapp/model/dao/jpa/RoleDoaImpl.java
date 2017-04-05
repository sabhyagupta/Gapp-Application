package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Users;
import gapp.model.role;
import gapp.model.dao.RoleDao;

@Repository
public class RoleDoaImpl implements RoleDao{
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public role getRole(Integer Roleid) {
		return (role) entityManager.find( role.class, Roleid );
	}

}
