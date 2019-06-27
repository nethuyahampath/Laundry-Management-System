package com.lms.model;

public class WashFoldRates extends Rates {

	protected String ratePackage;
	protected int smallWeightPrice;
	protected int mediumWeightPrice;
	protected int largeWeightPrice;

	public void setRatePackage(String ratePackage) {
		this.ratePackage = ratePackage;
	}

	public void setSmallWeightPrice( int smallWeightPrice ) {
		this.smallWeightPrice = smallWeightPrice;
	}
	
	public void setMediumWeightPrice(int mediumWeightPrice ) {
		this.mediumWeightPrice = mediumWeightPrice;
	}
	
	public void setLargeWeightPrice( int largeWeightPrice ) {
		this.largeWeightPrice = largeWeightPrice;
	}
	
	
	
	public String getRatePackage() {
		return ratePackage;
	}
	
	
	public int getSmallWeightPrice() {
		return  smallWeightPrice;
	}
	
	public int getMediumWeightPrice() {
		return mediumWeightPrice;
	}
	
	public int getLargeWeightPrice() {
		return largeWeightPrice; 
	}

	
}
