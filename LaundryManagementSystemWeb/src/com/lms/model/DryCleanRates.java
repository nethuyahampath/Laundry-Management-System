package com.lms.model;

public class DryCleanRates extends Rates {

	protected String rateItem;
	protected int pricePerUnit;

	public void setRateItem(String rateItem) {
		this.rateItem = rateItem;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getRateItem() {
		return rateItem;
	}

	public int getPricePerUnit() {
		return pricePerUnit;
	}
}
