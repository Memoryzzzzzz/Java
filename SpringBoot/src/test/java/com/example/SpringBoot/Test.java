package com.example.SpringBoot;

import java.util.Set;

import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args) {
		String str="select * from tables where id = #{id} and name = '#{anme}'";
		JSONObject match = new JSONObject();
		match.put("#{id}", 2);
		match.put("#{anme}", "liuli");
		System.out.println(match.toJSONString());
		 Set<String> keySet = match.keySet();
	        for(String key : keySet){
	        	System.out.println(match.get(key));
	        	str = str.replace(key, match.get(key).toString());
	        }
	      System.out.println(str);
	}
}
