package com.example.SpringBoot.invoice.nc;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) {
		CollectJSONDto conDto = new CollectJSONDto();
		List<ItemJsonDto> itemArray = new ArrayList<ItemJsonDto>();
		ItemJsonDto dto1 = new ItemJsonDto();
		dto1.setAmount("1200");
		dto1.setContract_code("CS0001");
		dto1.setBreed_name("大类1");
		dto1.setTaxRate("0.17");
		dto1.setNum("0.33");
		itemArray.add(dto1);
		
		ItemJsonDto dto2 = new ItemJsonDto();
		dto2.setAmount("1300");
		dto2.setContract_code("CS0002");
		dto2.setBreed_name("大类2");
		dto2.setTaxRate("0.17");
		dto2.setNum("0.33");
		itemArray.add(dto2);
		
		conDto.setAgentBuniness("0");
		conDto.setTotalamount("2500");
		conDto.setDataSource("1");
		conDto.setInvoiceCategory("1");
		conDto.setTicket_number("084252333");
		conDto.setItemArray(itemArray);
		conDto.setName("测试公司名");
		
		InputInvoiceNCTemplate inputInvoiceNCTemplate = new InputInvoiceNCTemplate();
		
		String [] array ={"ticket_number","name","breed_name","contract_code","amount","num"};
		JSONArray loadBorrow1 = inputInvoiceNCTemplate.loadBorrow1(JSONObject.toJSONString(conDto), array,true);
		JSONArray loadBorrow2 = inputInvoiceNCTemplate.loadBorrow2(JSONObject.toJSONString(conDto), array,true);
		JSONArray loadBorrow3 = inputInvoiceNCTemplate.loadBorrow3(JSONObject.toJSONString(conDto), array,true);
		System.out.println(loadBorrow1);
		System.out.println(loadBorrow2);
		System.out.println(loadBorrow3);
		/*JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(loadBorrow1);
		jsonArray.addAll(loadBorrow2);
		jsonArray.addAll(loadBorrow3);
		System.out.println(jsonArray);*/
		

	}

}
