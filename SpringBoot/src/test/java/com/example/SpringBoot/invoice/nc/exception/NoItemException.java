package com.example.SpringBoot.invoice.nc.exception;

public class NoItemException extends RuntimeException {
	
	/**    
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）        
	 * @since     
	 */    
	
	private static final long serialVersionUID = -8728589082746975638L;
	private String errorCode; //异常编码
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public NoItemException(){
		super();
	}
	
	public NoItemException(String message){
		super(message);
	}
	
	public NoItemException(String errorCode,String message){
		super(message);
		this.errorCode=errorCode;
	}
}
