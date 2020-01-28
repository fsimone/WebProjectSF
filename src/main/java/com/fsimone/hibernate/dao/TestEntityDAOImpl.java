package com.fsimone.hibernate.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import com.fsimone.hibernate.entity.TestEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class TestEntityDAOImpl implements TestEntityDAO {

	 @Autowired
	 private SessionFactory sessionFactory;


	@Override
	@SuppressWarnings("unchecked")
	public List<TestEntity> getAllTestEntity() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TestEntity> cq = cb.createQuery(TestEntity.class);
        Root<TestEntity> root = cq.from(TestEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public void saveTestEntity(TestEntity testEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(testEntity);
	}

	@Override
	public TestEntity getTestEntity(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		TestEntity testEntity = currentSession.get(TestEntity.class, theId);
        return testEntity;
	}

	@Override
	public void deleteTestEntity(int id) {
		Session session = sessionFactory.getCurrentSession();
		TestEntity testEntity = session.byId(TestEntity.class).load(id);
        session.delete(testEntity);
	}

}
