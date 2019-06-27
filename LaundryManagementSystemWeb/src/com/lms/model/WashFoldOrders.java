package com.lms.model;

public class WashFoldOrders extends Orders{

	protected String rateID;
	protected int weight;
	protected String orderPackage;
	
	public void setRateID( String rateID ) {
		this.rateID =  rateID;
	}
	
	public void setWeight( int weight ) {
		this.weight =  weight;
	}
	
	public void setOrderPackage( String orderPackage ) {
		this.orderPackage  = orderPackage;
	}
	
	public String getRateID() {
		return rateID;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getOrderPackage() {
		return orderPackage;
	}
}
