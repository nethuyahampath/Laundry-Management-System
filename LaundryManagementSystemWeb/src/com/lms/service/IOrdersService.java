package com.lms.service;

import com.lms.model.WashFoldOrders;

import java.util.ArrayList;

import com.lms.model.DryCleanOrders;
import com.lms.model.Orders;

public interface IOrdersService {
	public void addOrder(  Orders order );
	public void addWashFoldOrder(WashFoldOrders wfOrder );
	public void addDryCleanOrder(DryCleanOrders dcOrder );
	public void addDryCleanOrderStatus(DryCleanOrders dcOrder);
	public void addWashFoldOrderStatus(WashFoldOrders wfOrder);
	public ArrayList<Orders> getWashFoldOrders(String ID);
	public ArrayList<Orders> getDryCleanOrders(String ID);
	public WashFoldOrders getWashFoldOrderByID(String orderID);
	public DryCleanOrders getDryCleanOrderByID(String orderID);
	
	public double getTotalAmount( double weight, double smallPrice, double mediumPrice, double largePrice);
	public ArrayList<DryCleanOrders> MyDryCleanList(String orderID);
	public WashFoldOrders MyWashFoldList(String orderID);

	public String getPickDateByID( String orderID );
	public void updateOrders( String orderID , Orders order );
	public void updateDryCleanOrders( String orderID, DryCleanOrders dcOrder );
	public void updateWashFoldOrders( String orderID, WashFoldOrders wfOrder );

	public void removeOrders(String orderID);
	public void removeDryCleanOrders(String orderID);
	public void removeDryCleanStatus(String orderID);
	
	public void removeWashFoldOrders(String orderID);
	public void removeWashFoldStatus(String orderID);
	
	public String getOrderDeadLineMessage( String pickUpDate, String currentDate );
	
	//generate reports
	public ArrayList<WashFoldOrders> WashFoldStatusReport( String dropDate, String status);
	public ArrayList<DryCleanOrders> DryCleanStatusReport( String dropDate, String status);
	//admin and Staff
	
	public ArrayList<WashFoldOrders> getWashFoldOrdersStatusList();
	public void updateWashFoldStatus(String orderID, WashFoldOrders wfOrder );
	
	public ArrayList<DryCleanOrders> getDryCleanOrdersStatusList();
	public void updateDryCleanStatus(String orderID, DryCleanOrders dcOrder);
	
	public ArrayList<WashFoldOrders> getWashFoldWeight();
	public void updateWashFoldWeight(String orderID, int weight);
}
