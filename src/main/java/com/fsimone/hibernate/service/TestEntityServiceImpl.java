package com.fsimone.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsimone.hibernate.dao.TestEntityDAO;
import com.fsimone.hibernate.entity.TestEntity;



@Service
public class TestEntityServiceImpl implements TestEntityService {


    @Autowired
    private TestEntityDAO testEntityDAO;



	@Override
    @Transactional
	public List<TestEntity> getTestEntityList() {
		return testEntityDAO.getAllTestEntity();
	}

	@Override
	@Transactional
	public void saveTestEntity(TestEntity theCustomer) {
		testEntityDAO.saveTestEntity(theCustomer);
	}

	@Override
	@Transactional
	public TestEntity getTestEntity(int theId) {
		return testEntityDAO.getTestEntity(theId);
	}

	@Override
	@Transactional
	public void deleteTestEntity(int theId) {
		testEntityDAO.deleteTestEntity(theId);
	}

}
