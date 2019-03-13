package com.example.SpringBoot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.banksteel.finance.api.OutputInvoiceApi;

@RestController
public class InvoiceController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OutputInvoiceApi outputInvoiceApi;
    
    @RequestMapping("/queryInvoice")
    public String queryInvoice(String invoceNum,String invoceCode) {
        logger.info("发票号码:{},发票代码：{}",invoceNum,invoceCode);
        Map<String, Object> queryInvoiceInfoByNumAndCode =  null;
        try {
            queryInvoiceInfoByNumAndCode = outputInvoiceApi.queryInvoiceInfoByNumAndCode(invoceNum, invoceCode);
        } catch (Exception e) {
            logger.error("异常:",e);
        }
        logger.info("返回的结果：{}",queryInvoiceInfoByNumAndCode);
        return JSON.toJSONString(queryInvoiceInfoByNumAndCode);
    }
    
    @RequestMapping("/queryOfflineInvoice")
    public String queryOfflineInvoice(String invoceNum,String invoceCode) {
        
        List<Map<String,Object>> queryInvoiceInfoByNumAndCode =  null;
        try {
            Map<String,Object> param = new HashMap<String, Object>();
            param.put("platformId", "0");
            param.put("buyContractNo", "GY180723SJ000112");
            
            queryInvoiceInfoByNumAndCode = outputInvoiceApi.queryOfflineInvoice(param);
        } catch (Exception e) {
            logger.error("异常:",e);
        }
        logger.info("返回的结果：{}",queryInvoiceInfoByNumAndCode);
        return JSON.toJSONString(queryInvoiceInfoByNumAndCode);
    }
}
