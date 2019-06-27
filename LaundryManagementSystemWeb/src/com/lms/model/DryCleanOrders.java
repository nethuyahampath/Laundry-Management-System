package com.lms.model;

public class DryCleanOrders extends Orders{
	
	protected String rateID;
	protected int quantity;
	protected String item;
	protected int pricePerUnit;
	protected int price;
	
	public void setRateID( String rateID ) {
		this.rateID = rateID;
	}
	

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setItem( String item ) {
		this.item =  item;
	}
	
	public void setPricePerUnit( int pricePerUnit ) {
		this.pricePerUnit = pricePerUnit;
	}

	public void setPrice( int price ) {
		this.price =  price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getRateID() {
		return rateID;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getPricePerUnit() {
		return pricePerUnit;
	}
	
	public int getPrice() {
		return price;
	}
}
