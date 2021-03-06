package com.test.mybatis.domain;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String sex;

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
