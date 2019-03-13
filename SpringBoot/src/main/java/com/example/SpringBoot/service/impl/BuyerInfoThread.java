package com.example.SpringBoot.service.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class BuyerInfoThread<T> implements Runnable{
    private List<T> accountInfo;
    private JdbcTemplate jdbcTemplate;
    public BuyerInfoThread(List<T> accountInfo,JdbcTemplate jdbcTemplate){
    	this.accountInfo = accountInfo;
    	this.jdbcTemplate = jdbcTemplate;
    }
	@Override
	public void run() {
	   
		
	}

}
