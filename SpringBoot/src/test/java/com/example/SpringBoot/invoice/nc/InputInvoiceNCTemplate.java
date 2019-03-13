package com.example.SpringBoot.invoice.nc;


import cn.mysteel.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.SpringBoot.invoice.nc.exception.ErrorCode;
import com.example.SpringBoot.invoice.nc.exception.NoRequiredKeyException;

public class InputInvoiceNCTemplate {
	 
	 
	/**
	 * 
	 * loadBorrow1:获取不含税金额   
	 * @author liu.li 
	 * @return 
	 * @since JDK 1.7
	 */
	public JSONArray loadBorrow1(String message,String[] modelItem,boolean isCancel){
		JSONArray resArray = new JSONArray();
		JSONObject jsonObj = JSONObject.parseObject(message);
		JSONArray arrayobject = JSONArray.parseArray(jsonObj.get("itemArray").toString());
		for(Object itemObj : arrayobject){
			JSONObject items = (JSONObject)itemObj;
			JSONObject resValueObje = new JSONObject();
			for(String key : modelItem){
				if(items.containsKey(key)){
					resValueObje.put(key, items.getString(key));
				}else if(jsonObj.containsKey(key)){
					resValueObje.put(key, jsonObj.getString(key));
				}else{
					throw new NoRequiredKeyException(ErrorCode.NO_REQUIRED_KEY,key+"为模板必填，请求无该值");
				}
			}
			//计算出税额
			String tax= calculationTaxFree(items.getString("amount"),items.getString("taxRate"));
			resValueObje.put("amount", MoneyCalculateUtils.sub(items.getString("amount"), tax)); //含税总金额-税额=不含税金额
			if(isCancel){
				resValueObje.put("amount", MoneyCalculateUtils.multi(resValueObje.getString("amount"),"-1"));
			}
			resArray.add(resValueObje);
		}
		
		return resArray;
	}
	
	/**
	 * 
	 * loadBorrow1:获取税额   
	 * @author liu.li 
	 * @return 
	 * @since JDK 1.7
	 */
	public JSONArray loadBorrow2(String message,String[] modelItem,boolean isCancel){
		JSONArray resArray = new JSONArray();
		JSONObject jsonObj = JSONObject.parseObject(message);
		JSONArray arrayobject = JSONArray.parseArray(jsonObj.get("itemArray").toString());
		for(Object itemObj : arrayobject){
			JSONObject items = (JSONObject)itemObj;
			JSONObject resValueObje = new JSONObject();
			for(String key : modelItem){
				if(items.containsKey(key)){
					resValueObje.put(key, items.getString(key));
				}else if(jsonObj.containsKey(key)){
					resValueObje.put(key, jsonObj.getString(key));
				}else{
					throw new NoRequiredKeyException(ErrorCode.NO_REQUIRED_KEY,key+"为模板必填，请求无该值");
				}
			}
			//计算出税额
			String tax= calculationTaxFree(items.getString("amount"),items.getString("taxRate"));
			if(isCancel){
				tax = MoneyCalculateUtils.multi(tax,"-1",2);
			}
			resValueObje.put("tax_amount", tax); //含税总金额-税额=不含税金额
			resValueObje.remove("amount");
			resArray.add(resValueObje);
		}
		
		return resArray;
	}
	
	/**
	 * 
	 * loadBorrow3:获取
	 * @author liu.li 
	 * @return 
	 * @since JDK 1.7
	 */
	public JSONArray loadBorrow3(String message,String[] modelItem,boolean isCancel){
		JSONArray resArray = new JSONArray();
		JSONObject jsonObj = JSONObject.parseObject(message);
		JSONArray arrayobject = JSONArray.parseArray(jsonObj.get("itemArray").toString());
		for(Object itemObj : arrayobject){
			JSONObject items = (JSONObject)itemObj;
			JSONObject resValueObje = new JSONObject();
			for(String key : modelItem){
				if(items.containsKey(key)){
					resValueObje.put(key, items.getString(key));
				}else if(jsonObj.containsKey(key)){
					resValueObje.put(key, jsonObj.getString(key));
				}else{
					throw new NoRequiredKeyException(ErrorCode.NO_REQUIRED_KEY,key+"为模板必填，请求无该值");
				}
			}
			if(isCancel){
				resValueObje.put("amount", MoneyCalculateUtils.multi(resValueObje.getString("amount"),"-1"));
			}
			resArray.add(resValueObje);
		}
		
		return resArray;
	}
	
	
	public String calculationTaxFree(String totalAmount,String taxRate){
		if(StringUtils.isNotTrimEmpty(taxRate))taxRate="0.17";
	    return MoneyCalculateUtils.multi(totalAmount, taxRate, 2);
	}
	
	
	
}
