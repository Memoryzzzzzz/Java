package com.example.SpringBoot.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.SpringBoot.service.CollectionInputInvoiceService;
import com.example.SpringBoot.service.ShuiYouService;
@Service("collectionInputInvoiceService")
public class CollectionInputInvoiceServiceImpl implements
		CollectionInputInvoiceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public void collectionInfo() {
		String invocieinfo =null;
		try {
		   //TODO 请求税友数据，内部参数需要增加具体时间逻辑。。。。。
		   invocieinfo = ShuiYouService.loadInfoBySY();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isEmpty(invocieinfo))return;
		JSONObject jsonObject = JSONObject.parseObject(invocieinfo);
		String code = jsonObject.getString("code");
		int successCount=0;
		if(!StringUtils.isEmpty(code) && code.equals("0000")){//正常返回结果集
			JSONArray array = JSONArray.parseArray(jsonObject.getString("data"));
			if(!array.isEmpty()){
				for(Object item : array){
					JSONObject itemInfo =(JSONObject)item;
					long id = insertCustomer(itemInfo);
					System.out.println("保存后的ID为："+id);
					//保存货物明细
					JSONArray hwmxsarray = JSONArray.parseArray(itemInfo.getString("hwmxs"));
					if(!hwmxsarray.isEmpty()){
						for(Object hwmxitem : hwmxsarray){
							JSONObject itemhwmx =(JSONObject)hwmxitem;
							insertInvoicehwmx(itemhwmx,id);
						}
					}
					//保存销货清单
						JSONArray qdxxsarray = JSONArray.parseArray(itemInfo.getString("qdxxs"));
						if(!qdxxsarray.isEmpty()){
							for(Object qdxxsitem : qdxxsarray){
								JSONObject itemqdxxs =(JSONObject)qdxxsitem;
								insertInvoicexqqd(itemqdxxs,id);
						    }
						}
					++successCount;
					System.out.println("成功条数"+successCount);
				}
			}
		}
		
	}
	public long insertCustomer(final JSONObject itemInfo) {
        //TODO.
        final String sql = "INSERT INTO inputInvoiceInfo (fplx, fpdm, fphm, kprq, kpfmc, kpfsbh, kpfdzdh, kpfyhzh, spfmc, spfsbh, spfdzdh, spfyhzh, jqbh, hjje, slv, hjse, kpje, jym, beizhu, mw, kpr, skr, zfbz, qdbz, shfsbh, shfmc, fhfsbh, fhfmc, qzdzxx, yshwxx, czch, ccdw, swjgdm, swjgmc, jddm, jdhm, kpfdz, kpfdh, kpfkhyh, kpfkhzh, spfzjhm, cllx, cpxh, chandi, hgzh, jkzmsh, sjdh, fdjhm, clsbdh, dunwei, xzrs, scqymc, wspzhm, fpzt, rzzt, rzfs, xtrzbz, bqzt, skssq, zcyy, cjsj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                int i=0;
                ps.setString(++i, itemInfo.getString("fplx"));
                ps.setString(++i, itemInfo.getString("fpdm"));
                ps.setString(++i, itemInfo.getString("fphm"));
                ps.setString(++i, itemInfo.getString("kprq"));
                ps.setString(++i, itemInfo.getString("kpfmc"));
                ps.setString(++i, itemInfo.getString("kpfsbh"));
                ps.setString(++i, itemInfo.getString("kpfdzdh"));
                ps.setString(++i, itemInfo.getString("kpfyhzh"));
                ps.setString(++i, itemInfo.getString("spfmc"));
                ps.setString(++i, itemInfo.getString("spfsbh"));
                ps.setString(++i, itemInfo.getString("spfdzdh"));
                ps.setString(++i, itemInfo.getString("spfyhzh"));
                ps.setString(++i, itemInfo.getString("jqbh"));
                ps.setString(++i, itemInfo.getString("hjje"));
                ps.setString(++i, itemInfo.getString("slv"));
                ps.setString(++i, itemInfo.getString("hjse"));
                ps.setString(++i, itemInfo.getString("kpje"));
                ps.setString(++i, itemInfo.getString("jym"));
                ps.setString(++i, itemInfo.getString("beizhu"));
                ps.setString(++i, itemInfo.getString("mw"));
                ps.setString(++i, itemInfo.getString("kpr"));
                ps.setString(++i, itemInfo.getString("skr"));
                ps.setBoolean(++i, itemInfo.getBooleanValue("zfbz"));
                ps.setBoolean(++i, itemInfo.getBooleanValue("qdbz"));
                ps.setString(++i, itemInfo.getString("shfsbh"));
                ps.setString(++i, itemInfo.getString("shfmc"));
                ps.setString(++i, itemInfo.getString("fhfsbh"));
                ps.setString(++i, itemInfo.getString("fhfmc"));
                ps.setString(++i, itemInfo.getString("qzdzxx"));
                ps.setString(++i, itemInfo.getString("yshwxx"));
                ps.setString(++i, itemInfo.getString("czch"));
                ps.setString(++i, itemInfo.getString("ccdw"));
                ps.setString(++i, itemInfo.getString("swjgdm"));
                ps.setString(++i, itemInfo.getString("swjgmc"));
                ps.setString(++i, itemInfo.getString("jddm"));
                ps.setString(++i, itemInfo.getString("jdhm"));
                ps.setString(++i, itemInfo.getString("kpfdz"));
                ps.setString(++i, itemInfo.getString("kpfdh"));
                ps.setString(++i, itemInfo.getString("kpfkhyh"));
                ps.setString(++i, itemInfo.getString("kpfkhzh"));
                ps.setString(++i, itemInfo.getString("spfzjhm"));
                ps.setString(++i, itemInfo.getString("cllx"));
                ps.setString(++i, itemInfo.getString("cpxh"));
                ps.setString(++i, itemInfo.getString("chandi"));
                ps.setString(++i, itemInfo.getString("hgzh"));
                ps.setString(++i, itemInfo.getString("jkzmsh"));
                ps.setString(++i, itemInfo.getString("sjdh"));
                ps.setString(++i, itemInfo.getString("fdjhm"));
                ps.setString(++i, itemInfo.getString("clsbdh"));
                ps.setString(++i, itemInfo.getString("dunwei"));
                ps.setString(++i, itemInfo.getString("xzrs"));
                ps.setString(++i, itemInfo.getString("scqymc"));
                ps.setString(++i, itemInfo.getString("wspzhm"));
                ps.setInt(++i, itemInfo.getIntValue("fpzt"));
                ps.setInt(++i, itemInfo.getIntValue("rzzt"));
                ps.setInt(++i, itemInfo.getIntValue("rzfs"));
                ps.setInt(++i, itemInfo.getIntValue("xtrzbz"));
                ps.setInt(++i, itemInfo.getIntValue("bqzt"));
                ps.setString(++i, itemInfo.getString("skssq"));
                ps.setString(++i, itemInfo.getString("zcyy"));
                ps.setString(++i, itemInfo.getString("cjsj"));
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }
	
	public int insertInvoicehwmx(final JSONObject itemInfo,final Long invocieid) {
        //TODO.
        final String sql = "INSERT INTO `inputinvoice`.`hwmxs` (`invoiceId`, `hh`, `hwmc`, `ggxh`, `dw`, `sl`, `dj`, `je`, `slv`, `se`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                int i=0;
                ps.setLong(++i, invocieid);
                ps.setInt(++i, itemInfo.getIntValue("hh"));
                ps.setString(++i, itemInfo.getString("hwmc"));
                ps.setString(++i, itemInfo.getString("ggxh"));
                ps.setString(++i, itemInfo.getString("dw"));
                ps.setString(++i, itemInfo.getString("sl"));
                ps.setString(++i, itemInfo.getString("dj"));
                ps.setString(++i, itemInfo.getString("je"));
                ps.setString(++i, itemInfo.getString("slv"));
                ps.setString(++i, itemInfo.getString("se"));
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
	
	public int insertInvoicexqqd(final JSONObject itemInfo,final Long invocieid) {
        //TODO.
        final String sql = "INSERT INTO `inputinvoice`.`qdxxs` (`invoiceId`, `hh`, `hwmc`, `ggxh`, `dw`, `sl`, `dj`, `je`, `slv`, `se`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                int i=0;
                ps.setLong(++i, invocieid);
                ps.setInt(++i, itemInfo.getIntValue("hh"));
                ps.setString(++i, itemInfo.getString("hwmc"));
                ps.setString(++i, itemInfo.getString("ggxh"));
                ps.setString(++i, itemInfo.getString("dw"));
                ps.setString(++i, itemInfo.getString("sl"));
                ps.setString(++i, itemInfo.getString("dj"));
                ps.setString(++i, itemInfo.getString("je"));
                ps.setString(++i, itemInfo.getString("slv"));
                ps.setString(++i, itemInfo.getString("se"));
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}
