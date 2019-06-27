package com.lms.model;

public class Orders {
	protected String orderID;
	protected String orderDropDate;
	protected String orderPickDate;
	protected String orderStatus;
	protected String userID;
	protected Double total;
	
	public void setOrderID( String orderID ) {
		this.orderID =  orderID;
	}
	
	public void setOrderDropDate( String orderDropDate ) {
		this.orderDropDate = orderDropDate;
	}
	
	public void setOrderPickDate( String orderPickDate ) {
		this.orderPickDate = orderPickDate;
	}
	
	public  void setOrderStatus( String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void setUserID( String userID ) {
		this.userID = userID;
	}
	
	public void setTotal( Double total ) {
		this.total = total;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
	public String getOrderDropDate() {
		return orderDropDate;
	}
	
	public String getOrderPickDate() {
		return orderPickDate;
	} 
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public Double getTotal() {
		return total;
	}
}
