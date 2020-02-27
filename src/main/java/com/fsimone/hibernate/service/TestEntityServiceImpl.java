package com.fsimone.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fsimone.hibernate.dao.TestEntityDAO;
import com.fsimone.hibernate.entity.TestEntity;



@Service
public class TestEntityServiceImpl implements TestEntityService {


    @Autowired
    private TestEntityDAO testEntityDAO;



	@Override
    //@Transactional(propagation = Propagation.SUPPORTS) // usa la transazione corrente se esiste
	@Transactional
	public List<TestEntity> getTestEntityList() {
		return testEntityDAO.getAllTestEntity();
	}

	@Override
	//@Transactional(propagation = Propagation.MANDATORY) // usa necessariamente la transazione esistente
	@Transactional
	public void saveTestEntity(TestEntity theValue) {
		testEntityDAO.saveTestEntity(theValue);
	}

	@Override
	//@Transactional(propagation = Propagation.REQUIRED) // vede prima se c'e' una transazione già creata e poi la usa
	@Transactional
	public TestEntity getTestEntity(int theId) {
		return testEntityDAO.getTestEntity(theId);
	}

	@Override
	//@Transactional(isolation = Isolation.SERIALIZABLE) // massimo livello di isolamento
	@Transactional
	public void deleteTestEntity(int theId) {
		testEntityDAO.deleteTestEntity(theId);
	}

}
