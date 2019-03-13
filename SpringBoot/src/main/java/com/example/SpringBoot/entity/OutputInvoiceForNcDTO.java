package com.example.SpringBoot.entity;

import java.io.Serializable;

/**
 * 销项票采集信息dto
 * @author Administrator
 *
 */
public class OutputInvoiceForNcDTO implements Serializable{
	private static final long serialVersionUID = 1438169258021L;
	/**
	 * 发票ID
	 */
	private Long invoiceId; 
	/**
	 * 发票号码
	 */
	private String invoiceNum;
	/**
	 * 发票代码
	 */
	private String invoiceCode;
	/**
	 * 开票机号
	 */
	private String machineNr;
	/**
	 * 购方名称-买方名称
	 */
	private String partbName;
	/**
	 * 开票日期（完成时间）
	 */
	private Long invoiceTime;
	/**
	 * 业务请求日志ID
	 */
	private Long requestId;
	/**
	 * 交易类型标识（id）
	 */
	private Long buzTypeId;
	/**
	 * 业务系统标识（id）
	 */
	private Long buzSysId;
	/**
	 * 业务标识
	 */
	private String buzId;
	/**
	 * 业务模式
	 */
	private Integer buzMode;
	/**
	 * 品名
	 */
	private String breed;
	/**
	 * '税率
	 */
	private String taxRate;
	/**
	 * '单价
	 */
	private String price;
	/**
	 * 合同号
	 */
	private String contractCode;
	/**
	 * 任你花项目ID
	 */
	private Long rnhProjectId;
	/**
	 * 任你花工程配送项目ID
	 */
	private Long rnhDprojectId;
	/**
	 * 实际折让的金额
	 */
	private String discountAmount;
	/**
	 * 是否折让（0：默认不折让 1：折让）
	 */
	private Boolean isDiscount;
	/**
	 * 订单明细Id
	 */
	private Long resIdbak;
	/**
	 * 买家会员id
	 */
	private Long memberId; 
	/**
	 * 不含税总金额
	 */
	private String taxFreeAmount; 
	/**
	 * 不含税单价
	 */
	private String taxFreePrice;
	/**
	 * 税额
	 */
	private String taxAmount;
	/**
	 * 重量
	 */
	private String weight;
	
	
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getTaxFreeAmount() {
		return taxFreeAmount;
	}
	public void setTaxFreeAmount(String taxFreeAmount) {
		this.taxFreeAmount = taxFreeAmount;
	}
	public String getTaxFreePrice() {
		return taxFreePrice;
	}
	public void setTaxFreePrice(String taxFreePrice) {
		this.taxFreePrice = taxFreePrice;
	}
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getMachineNr() {
		return machineNr;
	}
	public void setMachineNr(String machineNr) {
		this.machineNr = machineNr;
	}
	public String getPartbName() {
		return partbName;
	}
	public void setPartbName(String partbName) {
		this.partbName = partbName;
	}
	public Long getInvoiceTime() {
		return invoiceTime;
	}
	public void setInvoiceTime(Long invoiceTime) {
		this.invoiceTime = invoiceTime;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getBuzTypeId() {
		return buzTypeId;
	}
	public void setBuzTypeId(Long buzTypeId) {
		this.buzTypeId = buzTypeId;
	}
	public Long getBuzSysId() {
		return buzSysId;
	}
	public void setBuzSysId(Long buzSysId) {
		this.buzSysId = buzSysId;
	}
	public String getBuzId() {
		return buzId;
	}
	public void setBuzId(String buzId) {
		this.buzId = buzId;
	}
	public Integer getBuzMode() {
		return buzMode;
	}
	public void setBuzMode(Integer buzMode) {
		this.buzMode = buzMode;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Long getRnhProjectId() {
		return rnhProjectId;
	}
	public void setRnhProjectId(Long rnhProjectId) {
		this.rnhProjectId = rnhProjectId;
	}
	public Long getRnhDprojectId() {
		return rnhDprojectId;
	}
	public void setRnhDprojectId(Long rnhDprojectId) {
		this.rnhDprojectId = rnhDprojectId;
	}
	public String getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Boolean getIsDiscount() {
		return isDiscount;
	}
	public void setIsDiscount(Boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
	public Long getResIdbak() {
		return resIdbak;
	}
	public void setResIdbak(Long resIdbak) {
		this.resIdbak = resIdbak;
	}
}
