package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Users;
import gapp.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Users getUsers(String email,String password) {
		List<Users> users = entityManager.createQuery( "from Users u where u.email= :email and u.password=:password ", Users.class )
				.setParameter("email",email)
				.setParameter("password",password)
				.getResultList();
		if(users.size() == 0)
			return null;
		else
			return users.get(0);
	}
	

	@Override
	@Transactional
	public Users saveUser(Users user) {
		return entityManager.merge(user);
	}


	@Override
	public List<Users> getUsers() {
		return null;
	}


	@Override
	public Users getUsers(String email) {
		return entityManager.createQuery( "from Users u where u.email= :email ", Users.class )
				.setParameter("email",email).getSingleResult();

	}

    

}
