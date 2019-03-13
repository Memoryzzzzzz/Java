package com.example.SpringBoot.entity;
import cn.mysteel.core.AbstractEntity;

/**
 * 
 * 进项票明细; InnoDB free: 47104 kB  数据库表：inputinvoiceinfo
 * 
 **/
public class Inputinvoiceinfo extends AbstractEntity{


	
	/**    
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）        
	 * @since     
	 */    
	
	private static final long serialVersionUID = 6292219232258106296L;

	/**发票类型(0：增值税专用发票1：增值税普通发票3：机动车销售统一发票4：增值税普通发票（电子版） )**/

	private Integer fplx;

	/**发票代码**/

	private String fpdm;

	/**发票号码**/

	private String fphm;

	/**开票日期**/

	private String kprq;

	/**开票方名称**/

	private String kpfmc;

	/**开票方识别号**/

	private String kpfsbh;

	/**开票方地址及电话**/

	private String kpfdzdh;

	/**开票方银行及账号**/

	private String kpfyhzh;

	/**受票方名称**/

	private String spfmc;

	/**受票方识别号**/

	private String spfsbh;

	/**受票方地址及电话**/

	private String spfdzdh;

	/**spfyhzh**/

	private String spfyhzh;

	/**机器编号**/

	private String jqbh;

	/**合计金额**/

	private String hjje;

	/**税率**/

	private String slv;

	/**合计税额**/

	private String hjse;

	/**价税合计**/

	private String kpje;

	/**校验码**/

	private String jym;

	/**备注**/

	private String beizhu;

	/**密文**/

	private String mw;

	/**开票人**/

	private String kpr;

	/**收款人**/

	private String skr;

	/**作废标志(0：正常 1：作废)**/

	private Boolean zfbz;

	/**清单标志(0：不存在清单 1：存在清单)**/

	private Boolean qdbz;

	/**收货方识别号**/

	private String shfsbh;

	/**收货方名称**/

	private String shfmc;

	/**发货方识别号**/

	private String fhfsbh;

	/**发货方名称**/

	private String fhfmc;

	/**起止地址信息**/

	private String qzdzxx;

	/**运输货物信息**/

	private String yshwxx;

	/**车种车号**/

	private String czch;

	/**车船吨位**/

	private String ccdw;

	/**主管税务机关代码**/

	private String swjgdm;

	/**主管税务机关名称**/

	private String swjgmc;

	/**机打代码**/

	private String jddm;

	/**机打号码**/

	private String jdhm;

	/**销货方地址**/

	private String kpfdz;

	/**销货方电话**/

	private String kpfdh;

	/**销货方开户银行**/

	private String kpfkhyh;

	/**销货方银行账号**/

	private String kpfkhzh;

	/**购货方证件号码**/

	private String spfzjhm;

	/**车辆类型**/

	private String cllx;

	/**厂牌型号**/

	private String cpxh;

	/**产地**/

	private String chandi;

	/**合格证号**/

	private String hgzh;

	/**进口证明书号**/

	private String jkzmsh;

	/**商检单号**/

	private String sjdh;

	/**发动机号码**/

	private String fdjhm;

	/**车辆识别代号/车架号码**/

	private String clsbdh;

	/**吨位**/

	private String dunwei;

	/**限乘人数**/

	private String xzrs;

	/**生产企业名称**/

	private String scqymc;

	/**完税凭证号码**/

	private String wspzhm;

	/**发票状态(1正常2红冲（蓝票）3作废4异常5失控6认证异常7红字)**/

	private Integer fpzt;

	/**认证状态(0未认证1已认证2已转出)**/

	private Integer rzzt;

	/**认证方式(1扫描认证2勾选认证)**/

	private Integer rzfs;

	/**系统认证标志(0非系统认证 1 系统认证)**/

	private Integer xtrzbz;

	/**补全状态(0未补全1已补全2手动补全3查无此票4信息不一致)**/

	private Integer bqzt;

	/**税款所属期**/

	private String skssq;

	/**转出原因**/

	private String zcyy;

	/**采集时间**/

	private String cjsj;



	public void setFplx(Integer fplx){
		this.fplx=fplx;
	}

	public Integer getFplx(){
		return this.fplx;
	}

	public void setFpdm(String fpdm){
		this.fpdm=fpdm;
	}

	public String getFpdm(){
		return this.fpdm;
	}

	public void setFphm(String fphm){
		this.fphm=fphm;
	}

	public String getFphm(){
		return this.fphm;
	}

	public void setKprq(String kprq){
		this.kprq=kprq;
	}

	public String getKprq(){
		return this.kprq;
	}

	public void setKpfmc(String kpfmc){
		this.kpfmc=kpfmc;
	}

	public String getKpfmc(){
		return this.kpfmc;
	}

	public void setKpfsbh(String kpfsbh){
		this.kpfsbh=kpfsbh;
	}

	public String getKpfsbh(){
		return this.kpfsbh;
	}

	public void setKpfdzdh(String kpfdzdh){
		this.kpfdzdh=kpfdzdh;
	}

	public String getKpfdzdh(){
		return this.kpfdzdh;
	}

	public void setKpfyhzh(String kpfyhzh){
		this.kpfyhzh=kpfyhzh;
	}

	public String getKpfyhzh(){
		return this.kpfyhzh;
	}

	public void setSpfmc(String spfmc){
		this.spfmc=spfmc;
	}

	public String getSpfmc(){
		return this.spfmc;
	}

	public void setSpfsbh(String spfsbh){
		this.spfsbh=spfsbh;
	}

	public String getSpfsbh(){
		return this.spfsbh;
	}

	public void setSpfdzdh(String spfdzdh){
		this.spfdzdh=spfdzdh;
	}

	public String getSpfdzdh(){
		return this.spfdzdh;
	}

	public void setSpfyhzh(String spfyhzh){
		this.spfyhzh=spfyhzh;
	}

	public String getSpfyhzh(){
		return this.spfyhzh;
	}

	public void setJqbh(String jqbh){
		this.jqbh=jqbh;
	}

	public String getJqbh(){
		return this.jqbh;
	}

	public void setHjje(String hjje){
		this.hjje=hjje;
	}

	public String getHjje(){
		return this.hjje;
	}

	public void setSlv(String slv){
		this.slv=slv;
	}

	public String getSlv(){
		return this.slv;
	}

	public void setHjse(String hjse){
		this.hjse=hjse;
	}

	public String getHjse(){
		return this.hjse;
	}

	public void setKpje(String kpje){
		this.kpje=kpje;
	}

	public String getKpje(){
		return this.kpje;
	}

	public void setJym(String jym){
		this.jym=jym;
	}

	public String getJym(){
		return this.jym;
	}

	public void setBeizhu(String beizhu){
		this.beizhu=beizhu;
	}

	public String getBeizhu(){
		return this.beizhu;
	}

	public void setMw(String mw){
		this.mw=mw;
	}

	public String getMw(){
		return this.mw;
	}

	public void setKpr(String kpr){
		this.kpr=kpr;
	}

	public String getKpr(){
		return this.kpr;
	}

	public void setSkr(String skr){
		this.skr=skr;
	}

	public String getSkr(){
		return this.skr;
	}

	public void setZfbz(Boolean zfbz){
		this.zfbz=zfbz;
	}

	public Boolean getZfbz(){
		return this.zfbz;
	}

	public void setQdbz(Boolean qdbz){
		this.qdbz=qdbz;
	}

	public Boolean getQdbz(){
		return this.qdbz;
	}

	public void setShfsbh(String shfsbh){
		this.shfsbh=shfsbh;
	}

	public String getShfsbh(){
		return this.shfsbh;
	}

	public void setShfmc(String shfmc){
		this.shfmc=shfmc;
	}

	public String getShfmc(){
		return this.shfmc;
	}

	public void setFhfsbh(String fhfsbh){
		this.fhfsbh=fhfsbh;
	}

	public String getFhfsbh(){
		return this.fhfsbh;
	}

	public void setFhfmc(String fhfmc){
		this.fhfmc=fhfmc;
	}

	public String getFhfmc(){
		return this.fhfmc;
	}

	public void setQzdzxx(String qzdzxx){
		this.qzdzxx=qzdzxx;
	}

	public String getQzdzxx(){
		return this.qzdzxx;
	}

	public void setYshwxx(String yshwxx){
		this.yshwxx=yshwxx;
	}

	public String getYshwxx(){
		return this.yshwxx;
	}

	public void setCzch(String czch){
		this.czch=czch;
	}

	public String getCzch(){
		return this.czch;
	}

	public void setCcdw(String ccdw){
		this.ccdw=ccdw;
	}

	public String getCcdw(){
		return this.ccdw;
	}

	public void setSwjgdm(String swjgdm){
		this.swjgdm=swjgdm;
	}

	public String getSwjgdm(){
		return this.swjgdm;
	}

	public void setSwjgmc(String swjgmc){
		this.swjgmc=swjgmc;
	}

	public String getSwjgmc(){
		return this.swjgmc;
	}

	public void setJddm(String jddm){
		this.jddm=jddm;
	}

	public String getJddm(){
		return this.jddm;
	}

	public void setJdhm(String jdhm){
		this.jdhm=jdhm;
	}

	public String getJdhm(){
		return this.jdhm;
	}

	public void setKpfdz(String kpfdz){
		this.kpfdz=kpfdz;
	}

	public String getKpfdz(){
		return this.kpfdz;
	}

	public void setKpfdh(String kpfdh){
		this.kpfdh=kpfdh;
	}

	public String getKpfdh(){
		return this.kpfdh;
	}

	public void setKpfkhyh(String kpfkhyh){
		this.kpfkhyh=kpfkhyh;
	}

	public String getKpfkhyh(){
		return this.kpfkhyh;
	}

	public void setKpfkhzh(String kpfkhzh){
		this.kpfkhzh=kpfkhzh;
	}

	public String getKpfkhzh(){
		return this.kpfkhzh;
	}

	public void setSpfzjhm(String spfzjhm){
		this.spfzjhm=spfzjhm;
	}

	public String getSpfzjhm(){
		return this.spfzjhm;
	}

	public void setCllx(String cllx){
		this.cllx=cllx;
	}

	public String getCllx(){
		return this.cllx;
	}

	public void setCpxh(String cpxh){
		this.cpxh=cpxh;
	}

	public String getCpxh(){
		return this.cpxh;
	}

	public void setChandi(String chandi){
		this.chandi=chandi;
	}

	public String getChandi(){
		return this.chandi;
	}

	public void setHgzh(String hgzh){
		this.hgzh=hgzh;
	}

	public String getHgzh(){
		return this.hgzh;
	}

	public void setJkzmsh(String jkzmsh){
		this.jkzmsh=jkzmsh;
	}

	public String getJkzmsh(){
		return this.jkzmsh;
	}

	public void setSjdh(String sjdh){
		this.sjdh=sjdh;
	}

	public String getSjdh(){
		return this.sjdh;
	}

	public void setFdjhm(String fdjhm){
		this.fdjhm=fdjhm;
	}

	public String getFdjhm(){
		return this.fdjhm;
	}

	public void setClsbdh(String clsbdh){
		this.clsbdh=clsbdh;
	}

	public String getClsbdh(){
		return this.clsbdh;
	}

	public void setDunwei(String dunwei){
		this.dunwei=dunwei;
	}

	public String getDunwei(){
		return this.dunwei;
	}

	public void setXzrs(String xzrs){
		this.xzrs=xzrs;
	}

	public String getXzrs(){
		return this.xzrs;
	}

	public void setScqymc(String scqymc){
		this.scqymc=scqymc;
	}

	public String getScqymc(){
		return this.scqymc;
	}

	public void setWspzhm(String wspzhm){
		this.wspzhm=wspzhm;
	}

	public String getWspzhm(){
		return this.wspzhm;
	}

	public void setFpzt(Integer fpzt){
		this.fpzt=fpzt;
	}

	public Integer getFpzt(){
		return this.fpzt;
	}

	public void setRzzt(Integer rzzt){
		this.rzzt=rzzt;
	}

	public Integer getRzzt(){
		return this.rzzt;
	}

	public void setRzfs(Integer rzfs){
		this.rzfs=rzfs;
	}

	public Integer getRzfs(){
		return this.rzfs;
	}

	public void setXtrzbz(Integer xtrzbz){
		this.xtrzbz=xtrzbz;
	}

	public Integer getXtrzbz(){
		return this.xtrzbz;
	}

	public void setBqzt(Integer bqzt){
		this.bqzt=bqzt;
	}

	public Integer getBqzt(){
		return this.bqzt;
	}

	public void setSkssq(String skssq){
		this.skssq=skssq;
	}

	public String getSkssq(){
		return this.skssq;
	}

	public void setZcyy(String zcyy){
		this.zcyy=zcyy;
	}

	public String getZcyy(){
		return this.zcyy;
	}

	public void setCjsj(String cjsj){
		this.cjsj=cjsj;
	}

	public String getCjsj(){
		return this.cjsj;
	}

}
