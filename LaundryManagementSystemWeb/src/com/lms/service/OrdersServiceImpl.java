package com.lms.service;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import com.lms.model.WashFoldOrders;
import com.lms.model.DryCleanOrders;
import com.lms.model.DryCleanRates;
import com.lms.model.Orders;
import com.lms.util.DBConnect;
import com.lms.util.Generator;
import com.lms.util.Constants;

public class OrdersServiceImpl implements IOrdersService {

	private static Connection con;
	private static PreparedStatement prepStmt1, prepStmt2, prepStmt3;
	private static PreparedStatement prepStmt;
	private static ResultSet resultSet;

	public void addOrder(Orders order) {
		try {
			con = DBConnect.getDBConnection();
			prepStmt1 = con.prepareStatement(Constants.QUERY_ADD_ORDER);

			prepStmt1.setString(Constants.COLUMN_INDEX_ONE, order.getOrderID());

			prepStmt1.setString(Constants.COLUMN_INDEX_TWO, order.getOrderDropDate());
			prepStmt1.setString(Constants.COLUMN_INDEX_THREE, order.getOrderPickDate());
			prepStmt1.setString(Constants.COLUMN_INDEX_FOUR, order.getUserID());

			prepStmt1.execute();
		} catch (Exception e) {
			System.out.println("Exception Add Order : " + e);
		}

	}

	public void addWashFoldOrder(WashFoldOrders wfOrder) {

		// String orderID = Generator.generateWashFoldOrdersID();

		try {
			con = DBConnect.getDBConnection();

			// add records to orders table
			// prepStmt1 = con.prepareStatement(Constants.QUERY_ADD_ORDER);

			// add records to wash_fold_orders table
			prepStmt2 = con.prepareStatement(Constants.QUERY_ADD_WASH_FOLD_ORDER);

			/*
			 * prepStmt1.setString(Constants.COLUMN_INDEX_ONE, wfOrder.getOrderID());
			 * 
			 * prepStmt1.setString(Constants.COLUMN_INDEX_TWO, wfOrder.getOrderDropDate());
			 * prepStmt1.setString(Constants.COLUMN_INDEX_THREE,
			 * wfOrder.getOrderPickDate());
			 */
			prepStmt2.setString(Constants.COLUMN_INDEX_ONE, wfOrder.getOrderID());
			prepStmt2.setString(Constants.COLUMN_INDEX_TWO, wfOrder.getRateID());
			prepStmt2.setInt(Constants.COLUMN_INDEX_THREE, wfOrder.getWeight());

			// prepStmt1.execute();
			prepStmt2.execute();

		} catch (Exception e) {
			System.out.println("Exception in adding : " + e);
		}
	}

	public void addDryCleanOrder(DryCleanOrders dcOrder) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt2 = con.prepareStatement(Constants.QUERY_ADD_DRY_CLEAN_ORDER);

			prepStmt2.setString(Constants.COLUMN_INDEX_ONE, dcOrder.getOrderID());
			prepStmt2.setString(Constants.COLUMN_INDEX_TWO, dcOrder.getRateID());
			prepStmt2.setInt(Constants.COLUMN_INDEX_THREE, dcOrder.getQuantity());

			prepStmt2.execute();

		} catch (Exception e) {
			System.out.println("Exception in adding Dry Clean Order : " + e);
		}
	}

	public void addDryCleanOrderStatus(DryCleanOrders dcOrder) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt3 = con.prepareStatement(Constants.QUERY_ADD_DRY_CLEAN_STATUS);

			prepStmt3.setString(Constants.COLUMN_INDEX_ONE, dcOrder.getOrderID());
			prepStmt3.setString(Constants.COLUMN_INDEX_TWO, dcOrder.getOrderStatus());

			prepStmt3.execute();

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}

	public void addWashFoldOrderStatus(WashFoldOrders wfOrder) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt3 = con.prepareStatement(Constants.QUERY_ADD_WASH_FOLD_STATUS);

			prepStmt3.setString(Constants.COLUMN_INDEX_ONE, wfOrder.getOrderID());
			prepStmt3.setString(Constants.COLUMN_INDEX_TWO, wfOrder.getOrderStatus());

			prepStmt3.execute();

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}

	public ArrayList<Orders> getWashFoldOrders(String ID) {

		ArrayList<Orders> orderList = new ArrayList<Orders>();

		try {
			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement(
					"SELECT DISTINCT o.order_id, o.drop_date, o.pick_date,  o.user_id,  wfs.status FROM orders o, wash_fold_orders wfo, wash_fold_status wfs WHERE user_id = ?  AND o.order_id = wfo.order_id AND o.order_id = wfs.order_id ORDER BY  o.drop_date DESC ");

			prepStmt.setString(1, ID);
			
			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				Orders o = new Orders();

				o.setOrderID(resultSet.getString(1));
				o.setOrderDropDate(resultSet.getString(2));
				o.setOrderPickDate(resultSet.getString(3));
				o.setUserID(resultSet.getString(4));
				o.setOrderStatus(resultSet.getString(5));

				orderList.add(o);
			}

		} catch (Exception e) {
			System.out.println("Exception display WashFold Orders : " + e);
		}

		return orderList;
	}

	public ArrayList<Orders> getDryCleanOrders(String ID) {

		ArrayList<Orders> orderList = new ArrayList<Orders>();

		try {
			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement(
					"SELECT DISTINCT o.order_id, o.drop_date, o.pick_date,  o.user_id,  dcs.status FROM orders o, dry_clean_orders dco, dry_clean_status dcs WHERE user_id = ? AND o.order_id = dco.order_id AND o.order_id = dcs.order_id ORDER BY  o.drop_date DESC ");

			prepStmt.setString(1, ID);
			
			resultSet = prepStmt.executeQuery();

			
			
			while (resultSet.next()) {
				Orders o = new Orders();

				o.setOrderID(resultSet.getString(1));
				o.setOrderDropDate(resultSet.getString(2));
				o.setOrderPickDate(resultSet.getString(3));
				o.setUserID(resultSet.getString(4));
				o.setOrderStatus(resultSet.getString(5));

				orderList.add(o);
			}

		} catch (Exception e) {
			System.out.println("Exception display Dry Clean Orders : " + e);
		}

		return orderList;
	}

	public WashFoldOrders getWashFoldOrderByID(String orderID) {

		WashFoldOrders wfOrder = new WashFoldOrders();
		

		try {
			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("SELECT wfo.order_id , wfo.weight, wfr.package, wfr.small_weight_price, wfr.medium_weight_price, wfr.large_weight_price FROM wash_fold_orders wfo, wash_fold_rates wfr WHERE wfo.rate_id = wfr.rate_id AND wfo.order_id = ?");
			prepStmt.setString(1, orderID);

			resultSet = prepStmt.executeQuery();

			int smallPrice = 0;
			int mediumPrice = 0;
			int largePrice = 0;
			double weight = 0;
			
			while (resultSet.next()) {
				wfOrder.setOrderID(resultSet.getString(1));
				wfOrder.setWeight(resultSet.getInt(2));
				wfOrder.setOrderPackage(resultSet.getString(3));
				
				weight = resultSet.getInt(2);
				
				smallPrice = resultSet.getInt(4);
				mediumPrice =  resultSet.getInt(5);
				largePrice = resultSet.getInt(6);
			}
			
			wfOrder.setTotal(getTotalAmount( weight,smallPrice, mediumPrice,largePrice));
			
		} catch (Exception e) {
			System.out.println("Exception  in selecting order : " + e);
		}

		return wfOrder;

	}
	
	public double getTotalAmount( double weight, double smallPrice, double mediumPrice, double largePrice) {
		
		double total = 0;
		double discount = 0;
		
		if( weight > 0 && weight < 10 )
			total = total + weight * smallPrice;
		else if( weight >= 10 && weight < 30 )
			total = total + weight * mediumPrice;
		else if( weight >= 30 )
			total = total + weight * largePrice;
		
		//calculate the total
		if( total >= 1500 && total < 2500 )
			discount = 5;
		else if( total >= 2500 && total < 4000 )
			discount = 10;
		else if( total >= 4000 )
			discount = 15;
		
		//calculate the discount with the total
		total = total - ( total * discount/100.0 );
		
		return total;
	}

	public DryCleanOrders getDryCleanOrderByID(String orderID) {

		DryCleanOrders dcOrder = new DryCleanOrders();
		double total = 0;
		String ID = "";
		Double price;

		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement(
					"SELECT dco.order_id , dco.quantity, dcr.item,dcr.price_per_unit FROM dry_clean_orders dco, dry_clean_rates dcr WHERE dco.rate_id = dcr.rate_id AND dco.order_id = ?");
			prepStmt.setString(1, orderID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {

				ID = resultSet.getString(1);
				total = total + resultSet.getInt(2) * resultSet.getInt(4);

			}
			dcOrder.setOrderID(ID);
			dcOrder.setTotal(total);

		} catch (Exception e) {
			System.out.println("Exception for DryClean order bill : " + e);
		}

		return dcOrder;
	}

	public ArrayList<DryCleanOrders> MyDryCleanList(String orderID) {

		ArrayList<DryCleanOrders> orderList = new ArrayList<DryCleanOrders>();

		try {
			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement(
					"SELECT dco.order_id, dcr.item, dcr.price_per_unit, dco.quantity, dco.rate_id FROM dry_clean_orders dco, dry_clean_rates dcr WHERE dco.rate_id = dcr.rate_id AND dco.order_id = ? ");
			prepStmt.setString(1, orderID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				DryCleanOrders dcOrder = new DryCleanOrders();

				dcOrder.setOrderID(resultSet.getString(1));
				dcOrder.setItem(resultSet.getString(2));
				dcOrder.setPrice(resultSet.getInt(3) * resultSet.getInt(4));
				dcOrder.setQuantity(resultSet.getInt(4));
				dcOrder.setRateID(resultSet.getString(5));

				orderList.add(dcOrder);
			}

		} catch (Exception e) {
			System.out.println("Exception at list : " + e);
		}

		return orderList;
	}
	
	public ArrayList<WashFoldOrders> WashFoldStatusReport( String dropDate, String status){
		
		ArrayList<WashFoldOrders> orderList = new ArrayList<WashFoldOrders>();
		
		
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT wfs.order_id, wfs.status, o.drop_date FROM wash_fold_status wfs, orders o WHERE wfs.status = ? AND wfs.order_id =  o.order_id AND o.drop_date = ?");
			
			prepStmt.setString(1, status);
			prepStmt.setString(2, dropDate);
			
			resultSet = prepStmt.executeQuery();
			
			while( resultSet.next()) {
				WashFoldOrders wfo = new WashFoldOrders();
				
				wfo.setOrderID(resultSet.getString(1));
				wfo.setOrderStatus(resultSet.getString(2));
				wfo.setOrderDropDate(resultSet.getString(3));
				
				orderList.add(wfo);
			}
			
		}catch(Exception e ) {
			System.out.println("Exception in report : " + e );
		}
		
		return orderList;
	}
	
	public ArrayList<DryCleanOrders> DryCleanStatusReport( String dropDate, String status){
		
		ArrayList<DryCleanOrders> orderList = new ArrayList<DryCleanOrders>();
		
		
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT dcs.order_id, dcs.status, o.drop_date FROM dry_clean_status dcs, orders o  WHERE dcs.status = 'Completed' AND dcs.order_id = o.order_id AND o.drop_date = ?");
			
			prepStmt.setString(1, status);
			prepStmt.setString(2, dropDate);
			
			resultSet = prepStmt.executeQuery();
			
			while( resultSet.next()) {
				DryCleanOrders dco = new DryCleanOrders();
				
				dco.setOrderID(resultSet.getString(1));
				dco.setOrderStatus(resultSet.getString(2));
				dco.setOrderDropDate(resultSet.getString(3));
				
				orderList.add(dco);
			}
			
		}catch(Exception e ) {
			System.out.println("Exception in report : " + e );
		}
		
		return orderList;
	}
	
	
	public WashFoldOrders MyWashFoldList(String orderID){
		
		WashFoldOrders wfOrders = new WashFoldOrders();
		
		try {
			con =  DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT wfo.order_id , wfr.package , wfr.rate_id FROM wash_fold_orders wfo, wash_fold_rates wfr WHERE wfo.rate_id = wfr.rate_id  AND wfo.order_id = ?");
			prepStmt.setString(1, orderID);
			
			resultSet =  prepStmt.executeQuery();
			
			while( resultSet.next() ) {
				
				wfOrders.setOrderID(resultSet.getString(1));
				wfOrders.setOrderPackage(resultSet.getString(2));
				wfOrders.setRateID(resultSet.getString(3));
			}
		}catch(Exception e) {
			System.out.println("Exception in My WF : " + e );
		}
		
		return wfOrders;
	}

	public String getPickDateByID(String orderID) {

		String date = "";

		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("SELECT pick_date FROM orders WHERE order_id = ? ");
			prepStmt.setString(1, orderID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				date = resultSet.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Exception in getting pick date : " + e);
		}

		return date;
	}

	public void updateOrders(String orderID, Orders order) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("UPDATE orders SET pick_date = ? WHERE order_id = ? ");
			prepStmt.setString(1, order.getOrderPickDate());
			prepStmt.setString(2, orderID);

			prepStmt.execute();

		} catch (Exception e) {
			System.out.println("Exception in order Update : " + e);
		}
	}

	public void updateDryCleanOrders(String orderID, DryCleanOrders dcOrder) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt = con
					.prepareStatement("UPDATE dry_clean_orders SET quantity = ? WHERE order_id = ? AND rate_id = ?");
			prepStmt.setInt(1, dcOrder.getQuantity());
			prepStmt.setString(2, orderID);
			prepStmt.setString(3, dcOrder.getRateID());

			prepStmt.execute();

		} catch (Exception e) {
			System.out.println("Exception in updating DCO : " + e);
		}
	}
	
	public void updateWashFoldOrders( String orderID, WashFoldOrders wfOrder ) {
		
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt =  con.prepareStatement("UPDATE wash_fold_orders SET rate_id = ? WHERE order_id = ?");
			
			prepStmt.setString( 1, wfOrder.getRateID());
			prepStmt.setString(2, wfOrder.getOrderID());
			
			prepStmt.execute();
			
		}catch(Exception e ) {
			System.out.println("Exceptoin in wash fold : " + e );
		}
	}

	public void removeOrders(String orderID) {

		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("DELETE FROM orders WHERE order_id = ?");
			prepStmt.setString(1, orderID);

			prepStmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception in removing Order : "  +  e );
		}
	}

	public void removeDryCleanOrders(String orderID) {
		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("DELETE FROM dry_clean_orders WHERE order_id = ?");
			prepStmt.setString(1, orderID);

			prepStmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception in removing DC Order : " + e);
		}
	}

	public void removeDryCleanStatus(String orderID) {
		try {

			con = DBConnect.getDBConnection();

			prepStmt = con.prepareStatement("DELETE FROM dry_clean_status WHERE order_id = ?");
			prepStmt.setString(1, orderID);

			prepStmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception in removing DC Order status : " +  e );
		}
	}
	
	public void removeWashFoldOrders(String orderID) {
		
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("DELETE FROM wash_fold_orders WHERE order_id = ?");
			prepStmt.setString(1, orderID);
			
			prepStmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Exceptoin in removing WFO :  " + e );
		}
	}
	
	public void removeWashFoldStatus(String orderID) {
		try {
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("DELETE FROM wash_fold_status WHERE order_id = ?");
			prepStmt.setString(1, orderID);
			
			prepStmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Exceptoin in removing WFS :  " + e );
		}
	}
	
	
	public ArrayList<WashFoldOrders> getWashFoldOrdersStatusList(){
		
		ArrayList<WashFoldOrders> orderList = new ArrayList<WashFoldOrders>();
		
		try {
			
			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement("SELECT * FROM wash_fold_status");
			
			resultSet = prepStmt.executeQuery();
			
			while (resultSet.next()) {
				
				WashFoldOrders WFO = new WashFoldOrders();
				
				WFO.setOrderID(resultSet.getString(1));
				WFO.setOrderStatus(resultSet.getString(2));
				
				orderList.add(WFO);
				
			}
			
		}catch(Exception e) {
			System.out.println("Exception in display WFR : " + e);
		}
		
		return orderList;

	}
	
	 public void updateWashFoldStatus(String orderID, WashFoldOrders wfOrder ) {
		 
		 try {
			 
			 con = DBConnect.getDBConnection();
			 
			 prepStmt = con.prepareStatement("UPDATE wash_fold_status SET status = ? WHERE order_id = ?");
			 
			 prepStmt.setString(1, wfOrder.getOrderStatus());
			 prepStmt.setString(2, wfOrder.getOrderID());
			 
			 prepStmt.execute();
			 
		 }catch(Exception e) {
			 System.out.println("Exception in display UWFRS : " + e);
		 }
		 
	 }
	 
	 
	 public ArrayList<DryCleanOrders> getDryCleanOrdersStatusList(){
			
			ArrayList<DryCleanOrders> orderList = new ArrayList<DryCleanOrders>();
			
			try {
				
				con = DBConnect.getDBConnection();
				
				prepStmt = con.prepareStatement("SELECT * FROM dry_clean_status");
				
				resultSet = prepStmt.executeQuery();
				
				while (resultSet.next()) {
					
					DryCleanOrders DCO = new DryCleanOrders();
					
					DCO.setOrderID(resultSet.getString(1));
					DCO.setOrderStatus(resultSet.getString(2));
					
					orderList.add(DCO);
					
				}
				
			}catch(Exception e) {
				System.out.println("Exception in display DCR : " + e);
			}
			
			return orderList;

		}
	 
	 public void updateDryCleanStatus(String orderID, DryCleanOrders dcOrder) {
		 
		 try {
			 
			 con = DBConnect.getDBConnection();
			 
			 prepStmt = con.prepareStatement("UPDATE dry_clean_status SET status = ? WHERE order_id = ?");
			 
			 prepStmt.setString(1, dcOrder.getOrderStatus());
			 prepStmt.setString(2, dcOrder.getOrderID());
			 
			 prepStmt.execute();
			 
			 
		 }catch(Exception e) {
			 System.out.println("Exception in display UDCRS" + e);
		 }
	 }
	 
	 public ArrayList<WashFoldOrders> getWashFoldWeight(){
		 
		 ArrayList<WashFoldOrders> orderList = new ArrayList<WashFoldOrders>();
			
		 
		 try {
			 
			 
			 con = DBConnect.getDBConnection();
			 
			 prepStmt = con.prepareStatement("SELECT order_id, weight FROM wash_fold_orders ");
			 
			 resultSet = prepStmt.executeQuery();
			 
			 while (resultSet.next()) {
					
					WashFoldOrders WFO = new WashFoldOrders();
					
					WFO.setOrderID(resultSet.getString(1));
					WFO.setWeight(resultSet.getInt(2));
					
					orderList.add(WFO);
					
				}
			 
		 }catch(Exception e){
			 System.out.println("Exception in display weight : " + e);
		 }
		 
		 return orderList;
	 }
	
	 public void updateWashFoldWeight(String orderID, int weight) {
		 
		 try {
			 
			 con = DBConnect.getDBConnection();
			 
			 prepStmt = con.prepareStatement("UPDATE wash_fold_orders SET weight = ? WHERE order_ID = ?");
			 
			 prepStmt.setInt(1, weight );
			 prepStmt.setString(2, orderID );
			 
			 prepStmt.execute();
			 
			 
		 }catch(Exception e) {
			 System.out.println("Exception " + e);
		 }
	 }
	 
	 public String getOrderDeadLineMessage( String pickUpDate, String currentDate ) {
		 
		 String message = "";

		 int totalDays = 0;
		 
		 
		 int pickMonth = Integer.parseInt(pickUpDate.substring(5,7));
		 int currentMonth = Integer.parseInt(currentDate.substring(5,7));
		 
		 int currentDay = Integer.parseInt(currentDate.substring(8,10));
		 int pickDay =   Integer.parseInt(pickUpDate.substring(8,10));
		 
		 int cm = currentMonth;
		 
		 
		 if( currentMonth == pickMonth ) { //check month
			 
			 if( pickDay > currentDay ) //check day
	
				 message = (pickDay - currentDay) + " days remaining  to the pick up";
			 
			 else
				 if( currentDay == pickDay ) //check day
					 
					 message = "You must pick up your order today ! ";
				 else
					 message = "Please pick up your order !... " +  ( currentDay - pickDay ) + " days late" ;
					 
		 }else
			 if( pickMonth  > currentMonth  ) {
				 
				 if( cm == 2) {
					 totalDays =  (  28 - currentDay )  + pickDay;
				 }
				 else
					 if( cm ==  1 || cm == 3 || cm == 5 ||  cm == 7  || cm == 8 || cm == 10 || cm == 12 ) {
						 totalDays =  (31 - currentDay) + pickDay;
					 }
					 else
						 totalDays = (30 - currentDay) + pickDay;
				 
				 message = totalDays  +  " days remaining to the pick up ";
			 }
			 else
				 if( pickMonth  < currentMonth ) {
					 
					 if( cm == 2 ) {
						 totalDays = ( 31 -  pickDay ) + currentDay;
					 }
					 else
						 if( cm ==  1 || cm == 3 || cm == 5 ||  cm == 7  || cm == 8 || cm == 10 || cm == 12 ) {
							 
							 if( pickMonth == 2 )
								 
								 totalDays = ( 28 - pickDay ) + currentDay;
							 else
								 totalDays = ( 30 - pickDay ) + currentDay;
						 }
						 else
							 totalDays = ( 31 - pickDay ) + currentDay;
					 
					 message = "Please pick up your order !... " +  totalDays + " days late" ;
				 }
		
		 
		 return message;
	 }
	 
	 
}
