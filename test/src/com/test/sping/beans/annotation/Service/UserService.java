package com.test.sping.beans.annotation.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void add(){
        System.out.println("UserService add...");
    }
}
