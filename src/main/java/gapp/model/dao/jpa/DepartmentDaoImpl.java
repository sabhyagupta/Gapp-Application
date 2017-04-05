package gapp.model.dao.jpa;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Contestant;
import gapp.model.Department;
import gapp.model.OtherRequirement;
import gapp.model.Users;
import gapp.model.role;
import gapp.model.dao.DepartmentDao;
@Repository
public class DepartmentDaoImpl  implements DepartmentDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	SharedSessionContract session;

    
    @Override
    public List<Department> getDepartment()
    {
        return entityManager.createQuery( "from Department order by dptname", Department.class )
            .getResultList();
    }
   /* public List<Department> getDepartment1(Integer pid,Integer dptid)
    {
Query query = session.createQuery(
        "select count(*) from  Department Programs where Department.dptid = Programs.pid");
	List<Department>  count = (List<Department>) query.uniqueResult();
	return count;	
    }*/

	@Override
	public Department getDepartment(Integer id) {
		return  entityManager.createQuery( "from Department where dptid=:id",Department.class )
				.setParameter("id",id).getSingleResult();
	}

	@Override
	public Department getDepartment(String dptname) {
		String query="from Department where dptname=:dptname";
		return entityManager.createQuery( query, Department.class ).setParameter("dptname", dptname).getSingleResult();
	}
	@Override
	@Transactional
	public Department saveDepartment(Department Department) {
		return entityManager.merge(Department);
	}

	@Override
	@Transactional
	public void updateDepartment(String dptname, Integer dptid) {
		entityManager.createQuery( "update " + Department.class.getName() + " set dptname = '" 
								+ dptname + "' where dptid = " + dptid).executeUpdate();
	}

	@Override
	public Department getDepartmentapplication(OtherRequirement id) {
		return entityManager.createQuery( "from Department order by id", Department.class ).getSingleResult();

	}
}
