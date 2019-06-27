package com.lms.util;

public class Constants {

	//Driver name
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	//DB URL
	public static final String DB_URL = "jdbc:mysql://localhost:3306/laundry_management_system?useSSL=false";
	
	//DB Username
	public static final String DB_USERNAME = "root";
	
	//DB Password
	public static final String DB_PASSWORD = "4123";
	
	
	//*** Queries ***
	
	//query to get all the Wash and Fold Rates
	public static final String QUERY_ALL_WASH_FOLD_RATES = "SELECT * FROM wash_fold_rates";
	
	//query to get all the Dry and Clean Rates
	public static final String QUERY_ALL_DRY_CLEAN_RATES = "SELECT * FROM dry_clean_rates";
	
	//query to get the Maximum Order ID from wash_fold_orders table
	public static final String QUERY_MAX_WF_ORDER_ID = "SELECT MAX(order_id) FROM wash_fold_orders";
	
	//query to get the Maximum Order ID from dry_clean_orders table
	public static final String QUERY_MAX_DC_ORDER_ID = "SELECT MAX(order_id) FROM dry_clean_orders";
	
	//query to get the Maximum Payment ID from payment table
	public static final String QUERY_MAX_PAYMENT_ID = "SELECT MAX(payment_id) FROM payment";
	
	//query to get the Maximum Review ID from the review table
	public static final String QUERY_MAX_REVIEW_ID = "SELECT MAX(review_id) FROM review";
	
	//query to add order records
	public static final String QUERY_ADD_ORDER = "INSERT INTO orders(order_id, drop_date, pick_date, user_id ) VALUES(?,?,?,?)";
	
	//query to add wash_fold_order records
	public static final String QUERY_ADD_WASH_FOLD_ORDER = "INSERT INTO wash_fold_orders(order_id, rate_id, weight) VALUES(?,?,?)";
	
	//query to add dry_clean_order records
	public static final String QUERY_ADD_DRY_CLEAN_ORDER = "INSERT INTO dry_clean_orders(order_id, rate_id, quantity) VALUES(?,?,?)";
	
	//query to add wash_fold_status records
	public static final String QUERY_ADD_WASH_FOLD_STATUS = "INSERT INTO wash_fold_status(order_id, status) VALUES(?,?)";
	
	//query to add wash_fold_status records
	public static final String QUERY_ADD_DRY_CLEAN_STATUS = "INSERT INTO dry_clean_status(order_id, status) VALUES(?,?)";
	
	//*** Column Indexes ***
	
	//column index 1 
	public static final int COLUMN_INDEX_ONE = 1;
	
	//column index 2
	public static final int COLUMN_INDEX_TWO = 2;
	
	//column index 3
	public static final int COLUMN_INDEX_THREE = 3;
	
	//column index 4
	public static final int COLUMN_INDEX_FOUR = 4;
	
	//column index 5
	public static final int COLUMN_INDEX_FIVE = 5;
}
