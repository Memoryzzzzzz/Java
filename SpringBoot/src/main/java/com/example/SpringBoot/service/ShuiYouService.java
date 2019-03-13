package com.example.SpringBoot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShuiYouService {
	public static String loadInfoBySY() throws Exception {
		As  as = new As();
		as.setSpfsbh("91310000671173033F");
		as.setCjrqq("2017-10-18");
		as.setCjrqz("2017-10-20");
		BufferedReader bufferedReader = null;
		String entity = null;
		ObjectMapper mapObj = new ObjectMapper();
		entity = mapObj.writeValueAsString(as);
		PostMethod postMethod = new PostMethod("http://192.168.200.213:8080/vtax-service/api/invoice/in/list");
		HttpClient client = new HttpClient();
						
		postMethod.addRequestHeader("Content-Type", "application/json");
						
		postMethod.setRequestEntity(new StringRequestEntity(entity, "application/json", "UTF-8"));
						
		int executeMethod = client.executeMethod(postMethod);
						 
		if (executeMethod == 200)
		{
			StringBuilder content = new StringBuilder();
			bufferedReader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(), "UTF-8"));
	    	String text;
		    while ((text = bufferedReader.readLine()) != null)
		    {
				content.append(text).append(System.getProperty("line.separator"));
			}

			bufferedReader.close();
			return content.toString();
			//System.out.println("返回结果:"+content.toString());
		}
		return null;
	}
	
	
}

class As{
	private String spfsbh;
	private String cjrqq;
	private String cjrqz;
	private Integer[] fplxs;
	private Integer[] fpzts;
	public String getSpfsbh() {
		return spfsbh;
	}
	public void setSpfsbh(String spfsbh) {
		this.spfsbh = spfsbh;
	}
	public String getCjrqq() {
		return cjrqq;
	}
	public void setCjrqq(String cjrqq) {
		this.cjrqq = cjrqq;
	}
	public String getCjrqz() {
		return cjrqz;
	}
	public void setCjrqz(String cjrqz) {
		this.cjrqz = cjrqz;
	}
	public Integer[] getFplxs() {
		return fplxs;
	}
	public void setFplxs(Integer[] fplxs) {
		this.fplxs = fplxs;
	}
	public Integer[] getFpzts() {
		return fpzts;
	}
	public void setFpzts(Integer[] fpzts) {
		this.fpzts = fpzts;
	}
	
}
