package com.example.SpringBoot.entity;

import cn.mysteel.core.AbstractEntity;

/**
 * 
 * 货物明细; InnoDB free: 47104 kB  数据库表：hwmxs
 * 
 **/
public class Hwmxs extends AbstractEntity{


	
	/**    
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）        
	 * @since     
	 */    
	
	private static final long serialVersionUID = 4754272496384826390L;
	private Integer hh;
	
	private Long invoiceId;
	
	/**货物或应税劳务名称**/

	private String hwmc;

	/**规格型号**/

	private String ggxh;

	/**单位**/

	private String dw;

	/**数量**/

	private String sl;

	/**单价**/

	private String dj;

	/**金额**/

	private String je;

	/**税率**/

	private String slv;

	/**税额**/

	private String se;
	
	



	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setHh(Integer hh){
		this.hh=hh;
	}

	public Integer getHh(){
		return this.hh;
	}

	public void setHwmc(String hwmc){
		this.hwmc=hwmc;
	}

	public String getHwmc(){
		return this.hwmc;
	}

	public void setGgxh(String ggxh){
		this.ggxh=ggxh;
	}

	public String getGgxh(){
		return this.ggxh;
	}

	public void setDw(String dw){
		this.dw=dw;
	}

	public String getDw(){
		return this.dw;
	}

	public void setSl(String sl){
		this.sl=sl;
	}

	public String getSl(){
		return this.sl;
	}

	public void setDj(String dj){
		this.dj=dj;
	}

	public String getDj(){
		return this.dj;
	}

	public void setJe(String je){
		this.je=je;
	}

	public String getJe(){
		return this.je;
	}

	public void setSlv(String slv){
		this.slv=slv;
	}

	public String getSlv(){
		return this.slv;
	}

	public void setSe(String se){
		this.se=se;
	}

	public String getSe(){
		return this.se;
	}

}
