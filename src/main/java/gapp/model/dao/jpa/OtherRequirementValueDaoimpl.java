package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Contestant;
import gapp.model.OtherRequirementValue;
import gapp.model.dao.OtherRequirementValueDao;

@Repository
public class OtherRequirementValueDaoimpl implements OtherRequirementValueDao {
	
	@PersistenceContext
    private EntityManager entityManager;


	@Override
	public List<OtherRequirementValue> getOtherRequirementValue(Integer id) {
		String Query = "select o from OtherRequirementValue o join o.Aid a where a.aid =  :id";
		return entityManager.createQuery(Query, OtherRequirementValue.class)
				.setParameter("id", id)
				.getResultList();
		}

	@Override
	public OtherRequirementValue getOtherRequirementValueedition(Integer ftid) {
		String Query = "from OtherRequirementValue where ftid=:id";
		return  entityManager.createQuery(Query, OtherRequirementValue.class).getSingleResult();	}

	@Override
	@Transactional
	public OtherRequirementValue saveOtherRequirementValue(OtherRequirementValue OtherRequirementValue) {
		return entityManager.merge(OtherRequirementValue);

	}

	@Override
	@Transactional
	public void updateOtherRequirementValue(Integer id, String txtvalue) {
		entityManager.createQuery( "update " + OtherRequirementValue.class.getName() + " set otherValue = :txtvalue where ftid = :id")
					.setParameter("txtvalue", txtvalue)
					.setParameter("id", id)
					.executeUpdate();
		
	}

	@Override
	public String getOldFileName(Integer ftid) {
		String Query = "from OtherRequirementValue where ftid= "+ftid;
		
		OtherRequirementValue otherRequirementValue = entityManager.createQuery(Query, OtherRequirementValue.class).getSingleResult();
		return otherRequirementValue.getOtherValue();
	}

	}


