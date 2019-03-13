package com.example.SpringBoot.invoice.nc;

public class NCItemGroupDTO {
	private String invoiceType; //发票类型（1-进项票 2-销项票）
	private String dataSource; //数据来源(1-收票，2-取消收票，3-代收代付，4-认证，5-取消认证)
    private String totalamount; //发票原始金额（原始票的开票金额amount，用来判断是否为红字发票）
    private String agentBuniness ; //代收代付（0,未代收代付  1,已代收代付）
    private String isApprove ; // 认证状态:0待认证 1已认证
    private String originalId; //进项票原始表Id
    private String ticketId ; //进项票已收票Id
    private String invoiceCategory; //发票类别
    private String invoiceNum; //发票号码
    private String invoiceCode; //发票代码
    private String title; //公司抬头
    private String itemName; //品名
	private String taxRate; //税率
	private String weight; //数量/重量
	private String amount; //金额
	private String contractNo; //合同号
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}
	public String getAgentBuniness() {
		return agentBuniness;
	}
	public void setAgentBuniness(String agentBuniness) {
		this.agentBuniness = agentBuniness;
	}
	public String getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}
	public String getOriginalId() {
		return originalId;
	}
	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getInvoiceCategory() {
		return invoiceCategory;
	}
	public void setInvoiceCategory(String invoiceCategory) {
		this.invoiceCategory = invoiceCategory;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
}
