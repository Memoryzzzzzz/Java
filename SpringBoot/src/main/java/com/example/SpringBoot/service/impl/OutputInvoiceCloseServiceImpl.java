package com.example.SpringBoot.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.entity.AccountOutputInvoiceClose;
import com.example.SpringBoot.entity.Maill;
import com.example.SpringBoot.service.OutputInvoiceCloseService;

@Service("outputInvoiceCloseService")
public class OutputInvoiceCloseServiceImpl implements OutputInvoiceCloseService{
	
	private static final String GENERATE_DATE="201708";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void run() {
    	groupByMaill();
        
        //System.out.println("###"+groupByMaill.size());
    }
    
    public void groupByMaill(){
    	final List<Maill> bueryTradeList = new ArrayList<Maill>();
    	final List<Maill> bueryrnhList = new ArrayList<Maill>();
        @SuppressWarnings("all")
        List<Maill> alllist = (List<Maill>) jdbcTemplate.query("select  memberId,userid,payType,sum(amount) as amount from maill group by memberId,userid,payType",  new ResultSetExtractor() {
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {  
                while (rs.next()) {  
                    Maill maill = new Maill();  
                    maill.setUserid(rs.getLong("userid"));
                    maill.setMemberId(rs.getLong("memberId"));
                    maill.setPayType(rs.getString("amount"));
                    maill.setAmount(rs.getString("amount"));
                    if(rs.getString("payType").equals("任你花付款")){
                    	bueryrnhList.add(maill);
                    }else{
                    	bueryTradeList.add(maill);
                    }
                }  
                return bueryrnhList;
            }  
        });  
    }
    
    public void saveAcounts(){
    	//---------------------------
    	Long startTime = System.currentTimeMillis();
    	List<AccountOutputInvoiceClose> getlist = getlist();
    	int total = getlist.size();
    	int threadNum = (int)Math.ceil(getlist.size()/10000);
		System.out.println("=====>共需要分配"+threadNum+"个线程");
		ExecutorService exe = Executors.newFixedThreadPool(threadNum);
		
		for(int a =0; a < threadNum ; a++){
			List<AccountOutputInvoiceClose> listSub = new ArrayList<AccountOutputInvoiceClose>();
			if(total<(a+1)*10000){
				listSub.addAll(getlist.subList(a*10000, total));
			}else{
				listSub.addAll(getlist.subList(a*10000, (a+1)*10000));
			}
			exe.execute(new BuyerInfoThread<AccountOutputInvoiceClose>(listSub,jdbcTemplate));
		}
		exe.shutdown();
		
		while(true){
			if(exe.isTerminated()){
				Long endTime = System.currentTimeMillis();
				System.out.println("台账关账完成，一共花费："+(endTime-startTime)/1000+"秒");
				break;
			}
		}
		//---------------------------
    }
    
    public List<AccountOutputInvoiceClose> getlist(){
    	 @SuppressWarnings("all")
         List<AccountOutputInvoiceClose> alllist = (List<AccountOutputInvoiceClose>) jdbcTemplate.query("select id,memberid,companyTitle,userid,username from finance_accsys_company_buyer_trade_user_info order by id asc ;",  new ResultSetExtractor() {
             public Object extractData(ResultSet rs) throws SQLException, DataAccessException {  
                 List<AccountOutputInvoiceClose> list = new ArrayList<AccountOutputInvoiceClose>();  
                 while (rs.next()) {  
                	 AccountOutputInvoiceClose maill = new AccountOutputInvoiceClose();  
                	 maill.setMemberId(rs.getLong("memberid"));
                     maill.setTitle(rs.getString("companyTitle"));
                     maill.setAccountType(7);
                     maill.setBeginOweTicket("0");
                     maill.setEndOweTicket("0");
                     maill.setBeginning("0");
                     maill.setEnding("0");
                     maill.setInExpectAmount("0");
                     maill.setInActualAmount("0");
                     maill.setOutActualAmount("0");
                     maill.setRnhId(0L);
                     maill.setUserId(rs.getLong("userid"));
                     maill.setUserName(rs.getString("username"));
                     maill.setGenerateDate(GENERATE_DATE);
                     maill.setCreateTime(System.currentTimeMillis());
                     maill.setAdminId(0L);
                     maill.setAdminName("");
                     maill.setDepartmentCode("");
                     maill.setDepartmentId(0L);
                     maill.setDepartmentName("");
                     maill.setTzzhType((byte)1);
                     list.add(maill);  
                 }  
                 return list;  
             }  
         });  
         return alllist;
    }
    

}
