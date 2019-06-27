package com.lms.service;

import java.util.ArrayList;

import com.lms.model.Orders;
import com.lms.model.Payment;

public interface IPaymentService {

	public void addPayment( Payment pay );
	public Double validateDeposit( String userID, double total );
	public void updateDepositAmount( String userID, double total );
	public Double getDeposit( String user_id) ;
	public void addDeposit( String userID ,Double newAmount );
	public void addDepositRecord( String userID ,Double newAmount );
	public ArrayList<Payment> getPaymentsByID(String userID);
	public void deletePaymentRecord(String paymentID);
	
}
