package com.fsimone.hibernate.service;

import java.util.List;

import com.fsimone.hibernate.entity.TestEntity;

public interface TestEntityService {

    public List <TestEntity> getTestEntityList();

    public void saveTestEntity(TestEntity theValue);

    public TestEntity getTestEntity(int theId);

    public void deleteTestEntity(int theId);

}
