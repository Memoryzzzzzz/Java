package com.example.SpringBoot.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController //controller里面的方法都以json格式输出
public class SteelController {
    private static final String String = null;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;
   
   
    
    
    @RequestMapping("/hello")
    public String index(){
        logger.info("into zhe controller{}",this.getClass());
        
       /* List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from finance_accsys_account_buz_log limit 10");
        logger.info("查询的结果:{}",queryForList);*/
        return "hello word!";
    }
    
    @RequestMapping("/check")
    @ResponseBody
    public String showCheckAccount(reqDto map){
    	 String time = map.getTime();
    	 String ids = map.getMemberId().toString();
    	 Map<String,Object> param = new HashMap<String, Object>();
    	 param.put("generateDate", map.getTime());
    	 param.put("memberId", map.getMemberId());
    	 try {
			Map<String, Object> accountInvoice =null;// currentAccountCompanyService.getAccountInvoice(param);
			 String jsonString = JSONObject.toJSONString(accountInvoice);
			 String replace = jsonString.replace("beginningInvoice", "期初欠票").replace("endInvoice", "期末欠票").replace("invoiceAmout", "本期实际已收金额").replace("list", "收票明细");
			 System.out.println(replace);
			/* inputInvoiceApi.queryInputInvoice(param);
			 inputInvoiceApi.queryInputInvoiceItemById(null);*/
			 return replace;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return time+"$$$"+ids;
    }
    
    @RequestMapping("/q")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public String checkInterface(reqDto dto){
    	Map<String,Object> param =  new HashMap<String,Object>();
    	param.put("currentPage", 1);
		param.put("pageSize", 10);
		//param.put("id", 201015L);
		Map<String, Object> queryInputInvoice = null; //inputInvoiceApi.queryInputInvoice(param);
		List<Map<String,Object>> list = (List<Map<String,Object>>)queryInputInvoice.get("list");
		Map<String, Object> map = list.get(0);
		String title = map.get("title").toString();
		String invoiceNum = map.get("invoiceNum").toString();
		String invoiceCode = map.get("invoiceCode").toString();
		String invoiceDate = map.get("invoiceDate").toString();
		String amount = map.get("amount").toString();
		String surplusAmount  = map.get("surplusAmount").toString();
		Long memberId  = map.get("memberId")==null?0L:Long.parseLong(map.get("memberId").toString());
		
		//组装收票的MQ
		JSONObject json = new JSONObject();
		json.put("buzId","111");
		json.put("id",201642L);
		json.put("title",title);
		json.put("memberId",memberId);
		json.put("invoiceCategory",11);
		json.put("invoiceNum",invoiceNum);
		json.put("invoiceCode",invoiceCode);
		json.put("amount","3100");
		json.put("receivedId",1001L);
		json.put("receivedName","测试下");
		json.put("receivedDepartId",1002L);
		json.put("receivedDepartName","测试下部门");
		json.put("receivedTime",System.currentTimeMillis());
		json.put("buzSysId",3L);
		json.put("buzSysName","库提整采系统");

		
		JSONArray array = new JSONArray();
		JSONObject item1 = new JSONObject();
		item1.put("id", null);
		item1.put("itemName", "螺纹钢");
		item1.put("spec", "F12");
		item1.put("price", "1100");
		item1.put("unit", "吨");
		item1.put("weight", "1");
		item1.put("amount", "1000");
		item1.put("taxRate", "0.17");
		item1.put("contractNo", "CS001021");
		array.add(item1);
		
		JSONObject item2 = new JSONObject();
		item2.put("id", null);
		item2.put("itemName", "盘螺");
		item2.put("spec", "F12");
		item2.put("price", "2000");
		item2.put("unit", "吨");
		item2.put("weight", "1");
		item2.put("amount", "1000");
		item2.put("taxRate", "0.17");
		item2.put("contractNo", "CS001022");
		array.add(item2);
		
		json.put("receiveItem",array);
		System.out.println(json.toJSONString());
		
    	return "ok";
    }
    @RequestMapping("/i")
    @ResponseBody
    public String checkinterfaceitem(reqDto dto){
    	 
    	List<Map<String,Object>> queryInputInvoice =null; // inputInvoiceApi.queryInputInvoiceItemById(Long.parseLong(dto.getId()));
    	return "ok"+queryInputInvoice;
    }
    
    public static void main(String[] args) {
    	JSONObject json = new JSONObject();
		json.put("buzId","3101");
		json.put("id",212827L);
		json.put("title","上海瑞冶联实业有限公司");
		json.put("memberId",null);
		
		json.put("invoiceNum","35772050");
		json.put("invoiceCode","3100172130");
		json.put("amount","150");
		json.put("receivedId",1001L);
		json.put("receivedName","测试下");
		json.put("receivedDepartId",1002L);
		json.put("receivedDepartName","测试下部门");
		json.put("receivedTime",System.currentTimeMillis());
		/*//库提整采发票
		json.put("buzSysId",3L);
		json.put("buzSysName","库提整采系统");
		json.put("invoiceCategory",3);*/
		//厂提整采发票
		json.put("buzSysId",18L);
		json.put("buzSysName","厂提整采系统");
		json.put("invoiceCategory",19);
		//帮你采
		/*json.put("buzSysId",23L);
		json.put("buzSysName","帮你采货物发票");
		json.put("invoiceCategory",11);*/
		//随你押
		/*json.put("buzSysId",24L);
		json.put("buzSysName","随你押货物发票");
		json.put("invoiceCategory",14);*/
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","帮你采返利发票");
		json.put("invoiceCategory",17);*/
		
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","帮你采仓储发票");
		json.put("invoiceCategory",12);*/
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","帮你采物流发票");
		json.put("invoiceCategory",13);*/
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","随你押采仓储发票");
		json.put("invoiceCategory",15);*/
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","随你押采物流发票");
		json.put("invoiceCategory",16);*/
		
		
		/*json.put("buzSysId",23L);
		json.put("buzSysName","库提整采运费发票");
		json.put("invoiceCategory",18);*/
		
 
		
		JSONArray array = new JSONArray();
		JSONObject item1 = new JSONObject();
		item1.put("id", 28317L);
		item1.put("itemName", "螺纹钢HRB400");
		item1.put("spec", "25*12");
		item1.put("price", "100");
		item1.put("unit", "吨");
		item1.put("weight", "0.5");
		item1.put("amount", "50");
		item1.put("taxRate", "0.17");
		item1.put("contractNo", "CS0001");
		array.add(item1);
		
		JSONObject item2 = new JSONObject();
		item2.put("id", 28317L);
		item2.put("itemName", "螺纹钢HRB400");
		item2.put("spec", "25*12");
		item2.put("price", "100");
		item2.put("unit", "吨");
		item2.put("weight", "1");
		item2.put("amount", "100");
		item2.put("taxRate", "0.17");
		item2.put("contractNo", "CS0002");
		array.add(item2);
		
		json.put("receiveItem",array);
		System.out.println("MQ:collect.input.invoice.ticket   "+json.toJSONString());
		
		
		JSONObject cancelObject = new JSONObject();
		cancelObject.put("buzId", 263345L);
		cancelObject.put("conllectId", 263345L);
		cancelObject.put("buzSysId", 3L);
		System.out.println("MQ:cancel.input.invoice.ticket   "+cancelObject.toJSONString());
		
		/*JSONObject josnJsonObject =  new JSONObject();
		josnJsonObject.put("flag", 1);
		josnJsonObject.put("buzId", 217L);
		josnJsonObject.put("buzSysId", 3L);
		josnJsonObject.put("conllectId", 262166L);
		josnJsonObject.put("msg", "收票成功！");
		System.out.println(josnJsonObject);*/

	}
    
    @RequestMapping("/sd")
    @ResponseBody
    public String copyInvoice(reqDto map){
    	map.setIds("5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
    	List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from finance_input_invoice_sy_invoiceinfo where id in"+"("+map.getIds()+")");
    	for(Map<String, Object> itemMap : queryForList){
    		jdbcTemplate.execute("INSERT INTO finance_input_invoice_original_record ( title, invoiceNum, invoiceCode, invoiceDate, sellDate, invoiceCategory, amount, surplusAmount, applyAdminId, applyAdminName, applyDepartmentId, applyDepartmentName, approveAdminId, approveAdminName, approveDepartmentId, approveDepartmentName, approveTime, maiAdminId, maiAdminName, maiDepartmentId, maiDepartmentCode, maiDepartmentName, managerId, managerName, directorId, directorName, lastAccess, receivedId, receivedName, receivedDepartId, receivedDepartName, receivedTime, createtime, memberId, isGet, isApprove, isRefund, isAdd, status, verifyDate, agentBuniness, isCheck, note, signId, signForBillNumber, signStatus, isInvalid, invalidId, invalidName, invalidDepartId, invalidDepartName, reason, invalidTime, isRelation) VALUES ( '"+itemMap.get("kpfmc")+"', '"+itemMap.get("fphm")+"', '"+itemMap.get("fpdm")+"', '2017-11-04', NULL, NULL, '"+itemMap.get("kpje")+"', '"+itemMap.get("kpje")+"', '196300', '常剑', '724', '财务产品研发部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1509968075552', '0', '', '0', '', NULL, '1509968075552', NULL, '0', '0', '0', '0', '1', NULL, NULL, '0', '', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, '0');");
    		
    		Long originalId = 0L;
    		String sql1="select * from finance_input_invoice_original_record where invoiceCode ='"+itemMap.get("fpdm")+"' and invoiceNum='"+itemMap.get("fphm")+"'";
    		List<Map<java.lang.String, Object>> list = jdbcTemplate.queryForList(sql1);
    		if(list != null && list.size()>0){
    			originalId = Long.parseLong(list.get(0).get("id").toString());
    		}
    		
    		Long id = 0L;
    		String sql="select * from finance_input_invoice_sy_invoiceinfo where fpdm ='"+itemMap.get("fpdm")+"' and fphm='"+itemMap.get("fphm")+"'";
    		List<Map<java.lang.String, Object>> queryForList2 = jdbcTemplate.queryForList(sql);
    		if(queryForList2 != null && queryForList2.size()>0){
    			id = Long.parseLong(queryForList2.get(0).get("id").toString());
    		}
    		
    		
    		
    		List<Map<String, Object>> itemList = jdbcTemplate.queryForList("select * from finance_input_invoice_sy_hwmxs where invoiceId ="+id);
    		for(Map<String, Object> mxMap : itemList){
    			BigDecimal sumAmt = new BigDecimal(mxMap.get("je").toString()).add(new BigDecimal(mxMap.get("se").toString()));
    			String amt = sumAmt.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    			
    			BigDecimal wight = new BigDecimal(mxMap.get("sl").toString());
    			String wt = wight.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
    			jdbcTemplate.execute("INSERT INTO finance_input_invoice_ticket_receivenot_item (originalId, itemName, spec, price, unit, contractNo, taxRate, weight, amount, createTime) VALUES ("+originalId+", '"+mxMap.get("hwmc")+"', '"+mxMap.get("ggxh")+"', '"+mxMap.get("dj")+"', '"+mxMap.get("dw")+"', '', '"+mxMap.get("slv")+"', '"+wt+"', '"+amt+"', "+System.currentTimeMillis()+");");
    		}

    		
    	}
    	return "OK";
    	
    }
    
    @RequestMapping("/delnot")
    @ResponseBody
    public String DelNotBreed(){
    	//select * from finance_nc_invocie_request_info where isError=1 and exceptionType=4 and isDealSuccess=1
    	List<Map<String, Object>> itemList = jdbcTemplate.queryForList("select * from finance_nc_invocie_request_info");
		for(Map<String, Object> mxMap : itemList){
			String item = mxMap.get("request_content").toString();
			JSONObject messageJson = JSONObject.parseObject(item);
			String itemArray = messageJson.get("itemArray").toString();
			List<InputTicketItemDTO> items = JSON.parseArray(itemArray,InputTicketItemDTO.class);
			for(InputTicketItemDTO dto : items){
				List<Map<java.lang.String, Object>> queryForList = jdbcTemplate.queryForList("select * from finance_sys_materiel_breed where breed = '"+dto.getBreed()+"'");
				if(queryForList == null || queryForList.size()<1){
					System.out.println(dto.getBreed());
					
					insertdata(dto.getBreed());

				}
				
			}

		}

    	 
    	
    	return "Ok";
    }
    
    
    void insertdata(String breed){
		try {
			jdbcTemplate.execute("INSERT INTO finance_sys_materiel_confirm (breed) VALUES ('"+breed+"')");
		} catch (DataAccessException e) {
		   System.out.println("重复");
		}

    }
    
    
   
    
    
}
