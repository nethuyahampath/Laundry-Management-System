package com.lms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lms.model.Payment;
import com.lms.util.DBConnect;

public class PaymentServiceImpl implements IPaymentService{

	private static Connection con;
	private static PreparedStatement prepStmt;
	private static ResultSet resultSet;
	
	public void addPayment( Payment pay ) {
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("INSERT INTO payment(payment_id, payment_date, amount, order_type, user_id, order_id)  VALUES(?,?,?,?,?,?)");   
			
			prepStmt.setString(1, pay.getPaymentID());
			prepStmt.setString(2, pay.getPaymentDate());
			prepStmt.setDouble(3, pay.getAmount());
			prepStmt.setString(4, pay.getOrderType());
			prepStmt.setString(5, pay.getUserID());
			prepStmt.setString(6, pay.getOrderID());
			
			prepStmt.execute();
			
		}catch( Exception e ) {
			System.out.println("Exception in payment : " + e );
		}
	}
	
	public Double validateDeposit( String userID , double total) {
		
		double amount = 0;
		
		try {
			
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT * FROM deposit WHERE user_id = ?");
			
			prepStmt.setString(1, userID);
			
			resultSet =  prepStmt.executeQuery();
			
			while( resultSet.next() ) {
		
				amount = resultSet.getDouble(2);
				
			}
			
			
		}catch( Exception  e ) {
			System.out.println("Exception in validating : " + e );
		}finally {
			System.out.println( amount - total );
		}
		
		if( amount > total )
			return (amount - total);
		else
			return null;
		
	}
	
	public void updateDepositAmount( String userID, double total ) {
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("UPDATE deposit SET amount = ? WHERE user_id  =  ?");
			
			prepStmt.setDouble(1, total);
			prepStmt.setString(2, userID);
			
			prepStmt.execute();
		}catch( Exception e ) {
			System.out.println("Exception in updating deposit : " + e );
		}
	}
	
	
	public Double getDeposit( String user_id) {
		
		
		double amount=0;
		
		
		
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT amount FROM deposit WHERE user_id  =  ?");
			
			prepStmt.setString(1, user_id);
			
			
			prepStmt.execute();
			
			resultSet =  prepStmt.executeQuery();
			
			
			
			while( resultSet.next() ) {
		
				amount = resultSet.getInt(1);
				
			}
		}catch( Exception e ) {
			System.out.println("Exception in updating deposit : " + e );
		}
		
		return amount;
	}
	
	
	
	public void addDeposit( String userID ,Double newAmount ) {
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("UPDATE deposit SET amount = ? WHERE user_id  =  ?");   
			
			prepStmt.setDouble(1, newAmount);
			prepStmt.setString(2, userID);
			
			
			prepStmt.execute();
			
		}catch( Exception e ) {
			System.out.println("Exception in adding deposit : " + e );
		}
	}
	
	
	public void addDepositRecord( String userID ,Double newAmount ) {
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("INSERT INTO deposit (user_id,amount) VALUES (?,?)");   
			
			prepStmt.setString(1, userID);
			prepStmt.setDouble(2, newAmount);
			
			
			prepStmt.execute();
			
		}catch( Exception e ) {
			System.out.println("Exception in adding deposit : " + e );
		}
	}
	
	public ArrayList<Payment> getPaymentsByID(String userID){
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		
		try {
			
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT * FROM payment WHERE user_id = ?");
			
			prepStmt.setString(1, userID );
			
			resultSet = prepStmt.executeQuery();
			
			while( resultSet.next() ) {
				Payment pay = new Payment();
				
				pay.setPaymentID(resultSet.getString(1));
				pay.setPaymentDate(resultSet.getString(2));
				pay.setAmount(resultSet.getInt(3));
				pay.setOrderType(resultSet.getString(4));
				pay.setUserID(resultSet.getString(5));
				pay.setOrderID(resultSet.getString(6));
			
				paymentList.add(pay);
			}
		}catch( Exception e ) {
			System.out.println("Exception  : " + e );
		}
		
		return paymentList;
		
	}
	

	public void deletePaymentRecord(String paymentID) {

		
	
			try {
				con = DBConnect.getDbConnection();
				prepStmt = con.prepareStatement("delete from payment"
						+ " where payment_id = ?");
				
				
				
				prepStmt.setString(1, paymentID);
	
				prepStmt.executeUpdate();
			
			
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			} finally {
				
				try {
					if (prepStmt != null) {
						prepStmt.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e) {
					System.out.println( "Exception : " + e );
				}
			}
	}
}
