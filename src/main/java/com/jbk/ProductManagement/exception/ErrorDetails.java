package com.jbk.ProductManagement.exception;

import java.util.Date;

public class ErrorDetails {
	
	private String errorMsg;
	private String details;
	private Date timestamp;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String errorMsg, String details, Date timestamp) {
		super();
		this.errorMsg = errorMsg;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorDetails [errorMsg=" + errorMsg + ", details=" + details + ", timestamp=" + timestamp + "]";
	}

	
	

}
