package com.fsimone.hibernate.dao;


import java.util.List;

import com.fsimone.hibernate.entity.TestEntity;


public interface TestEntityDAO {

	public List<TestEntity> getAllTestEntity();

    public void saveTestEntity(TestEntity testEntity);

    public TestEntity getTestEntity(int theId);

    public void deleteTestEntity(int theId);

}
