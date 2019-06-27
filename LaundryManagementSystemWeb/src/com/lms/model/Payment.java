package com.lms.model;

public class Payment {
	private String paymentID;
	private String paymentDate;
	private String orderType;
	private double amount;
	private String userID;
	private String orderID;
	
	public void setPaymentID( String paymentID ) {
		this.paymentID = paymentID;
	}
	
	public void setPaymentDate( String paymentDate ) {
		this.paymentDate = paymentDate;
	}
	
	public void setOrderType( String orderType ) {
		this.orderType = orderType;
	}
	
	public void setAmount( double amount ) {
		this.amount  = amount;
	}
	
	public void setUserID( String userID ) {
		this.userID = userID;
	}
	
	public void setOrderID( String orderID ) {
		this.orderID = orderID;
	}
	
	public String getPaymentID() {
		return paymentID;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
	public String getPaymentDate() {
		return paymentDate;
	}
}
