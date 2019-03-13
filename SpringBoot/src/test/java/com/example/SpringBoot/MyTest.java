package com.example.SpringBoot;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.test.context.SpringBootTest;  
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.banksteel.finance.api.InputInvoiceApi;
  
  
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类   
@ImportResource({"spring-dubbo.xml"})
public class MyTest {
	/*@Autowired
	private OutputInvoiceCloseService outputInvoiceCloseService;*/
/*	@Autowired
	private CollectionInputInvoiceService collectionInputInvoiceService;*/
	
	@Autowired
	private InputInvoiceApi inputInvoiceApi;
 
	@Test
	public void test(){
		//collectionInputInvoiceService.collectionInfo();
	}
	@Test
	public void testservice(){
		Map<String,Object> param =  new HashMap<String,Object>();
		param.put("currentPage", 1);
		param.put("pageSize", 10);
		//Map<String, Object> queryInputInvoice = inputInvoiceApi.queryInputInvoice(param);
		 
	}
	
    public static void main(String[] args) {
    	// V2SP26 5个 任务数 90
        double works=143; //任务数  163 -5(合并掉) =158 
        double temcode=5; //总人数
        double bugcount=10; //bug数据
		//System.out.println((工作量/团队人数)*0.3+(100*(1-BUG数/工作量))*85%+100*1/1*5%);
		System.out.println((works/temcode)*0.3+(100*(1-bugcount/works))*0.85+100*1/1*0.05);
	}
}
