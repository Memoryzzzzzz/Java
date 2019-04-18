package com.test.mybatis.dto;

import java.io.Serializable;

/**
 * 查询对应的查询条件
 */
public class UserSearchParam implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
