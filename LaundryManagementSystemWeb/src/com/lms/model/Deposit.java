package com.lms.model;

public class Deposit {

	
	private String deposit_id;
	  private int amount;
	  private String user_id;
	  
	  
	  
	  	public String getDeposit_id() {
			return deposit_id;
		}
		public void setDeposit_id(String deposit_id) {
			this.deposit_id = deposit_id;
		}
		
		
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
		
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
}
