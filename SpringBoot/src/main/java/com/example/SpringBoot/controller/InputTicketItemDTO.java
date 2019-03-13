package com.example.SpringBoot.controller;


public class InputTicketItemDTO {

	private String breed;//品名
	private String taxRate; //税率
	private String num;//数量
	private String amount;//金额 
	private String contract_code;//合同号
	
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getContract_code() {
		return contract_code;
	}
	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	
	public static void main(String[] args) {
		Dtos dto = new Dtos();
		dto.setBuzTypeId(1L);
		dto.setNote("财务取消转账，故进行退款");
	     if((dto.getBuzTypeId() != null && 
         		(dto.getBuzTypeId() != 1L && dto.getBuzTypeId() != 3L && dto.getBuzTypeId() != 4L)) ||  (dto.getNote() != null && dto.getNote().equals("财务取消转账，故进行退款")) ){
	    	 System.out.println("满足");
	     } else{
	    	 System.out.println("不满足");
	     }
	}
	

}
class Dtos{
	private Long buzTypeId;
	private String note;
	public Long getBuzTypeId() {
		return buzTypeId;
	}
	public void setBuzTypeId(Long buzTypeId) {
		this.buzTypeId = buzTypeId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
