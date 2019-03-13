package com.example.SpringBoot.entity;


/**
* 销项票发票关账表
* 类说明 ：finance_accsys_account_output_invoice_close
* banksteel-finance-entity
* com.banksteel.account.entity.AccountOutputInvoiceClose.java
* @author fangchao
* 创建时间：2016年11月22日 上午9:23:58 
 */
public class AccountOutputInvoiceClose {
	

	private static final long serialVersionUID = 6844983865613221910L;
	
	
	private Long memberId;           //公司ID（如果是供应商账户，则无值）
	private String title;            // 公司抬头

	private Integer accountType;     //账户类型5-买家任你花账户，7-买家现货用户账户
	private Integer buzMode;	     //业务模式（代理寄售，预付寄售，预付厂提等）
	private String beginOweTicket;	 //期初欠票
	private String endOweTicket;	 //期末欠票
	private String beginning;	     //期初预计应开票
	private String ending;	         //期末预计应开票
	private String inExpectAmount;	 //本月预计应开票
	private String inActualAmount;	 //本月实际应开票
	private String outActualAmount;	 //本月实际已开票
	private Long rnhId;              //任你花信用账户ID
	private Long userId;             //用户ID
	private String userName;         //用户名
	private String generateDate;     //账期[201511]
	private Long createTime;         //创建时间
	
	private Long adminId;            //商家管理员ID     
	private String adminName;        //商家管理员姓名
	private String departmentCode;   //部门code
	private Long departmentId;       //部门ID
	private String departmentName;   //部门名称
	
	private Byte tzzhType;    //台账账户类型1-用户 2-任你花 
	
	

	public Byte getTzzhType() {
		return tzzhType;
	}
	public void setTzzhType(Byte tzzhType) {
		this.tzzhType = tzzhType;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Integer getBuzMode() {
		return buzMode;
	}
	public void setBuzMode(Integer buzMode) {
		this.buzMode = buzMode;
	}
	public String getBeginOweTicket() {
		return beginOweTicket;
	}
	public void setBeginOweTicket(String beginOweTicket) {
		this.beginOweTicket = beginOweTicket;
	}
	public String getEndOweTicket() {
		return endOweTicket;
	}
	public void setEndOweTicket(String endOweTicket) {
		this.endOweTicket = endOweTicket;
	}
	public String getBeginning() {
		return beginning;
	}
	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}
	public String getEnding() {
		return ending;
	}
	public void setEnding(String ending) {
		this.ending = ending;
	}
	public String getInExpectAmount() {
		return inExpectAmount;
	}
	public void setInExpectAmount(String inExpectAmount) {
		this.inExpectAmount = inExpectAmount;
	}
	public String getInActualAmount() {
		return inActualAmount;
	}
	public void setInActualAmount(String inActualAmount) {
		this.inActualAmount = inActualAmount;
	}
	public String getOutActualAmount() {
		return outActualAmount;
	}
	public void setOutActualAmount(String outActualAmount) {
		this.outActualAmount = outActualAmount;
	}
	public Long getRnhId() {
		return rnhId;
	}
	public void setRnhId(Long rnhId) {
		this.rnhId = rnhId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

}
