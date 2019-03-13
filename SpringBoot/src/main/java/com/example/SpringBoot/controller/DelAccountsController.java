package com.example.SpringBoot.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;


@RestController //controller里面的方法都以json格式输出
public class DelAccountsController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    @RequestMapping("/delaccounts")
    public String index(){
    	List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select *from finance_buz_close limit 1");
        logger.info(JSON.toJSONString(queryForList));
    	List<Map<String, Object>> queryForList1 = jdbcTemplate.queryForList("select * from finance_invoice_v2.finance_input_invoice_signfor_log limit 1");
    	  logger.info(JSON.toJSONString(queryForList1));
    	return "hello word!";
    }
    
   
    
}
