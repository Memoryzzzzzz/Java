package com.test.sping.beans.annotation.repository;

import com.test.sping.beans.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired(required = false)
    public TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepository Save...");
        System.out.println(testObject);
    }

}
