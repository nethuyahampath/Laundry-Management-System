package com.lms.util;

public class CommonConstant {

		//Driver name
		public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		
		//DB URL
		public static final String DB_URL = "jdbc:mysql://localhost:3306/laundry_management_system?useSSL=false";
		//public static final String DB_URL = "jdbc:mysql://localhost:3306/laundry_management_system";
		
		//DB Username
		public static final String DB_USERNAME = "root";
		
		//DB Password
		public static final String DB_PASSWORD = "4123";
		
		
		//*** Queries ***
		
		
		//query to get the Maximum userID from user table
		public static final String QUERY_MAX_USER_ID = "SELECT MAX(userID) FROM user";
		
		//query to get the Maximum adminID from user table
		public static final String QUERY_MAX_ADMIN_ID = "SELECT MAX(userID) FROM user";
		
		//query to add users
		public static final String QUERY_ADD_USER = "INSERT INTO user(userID,firstName,lastName,password,no,street,city,contact,email,type) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		//query to get all users
		public static final String QUERY_ALL_USERS = "SELECT * FROM user";
		
		//query to get all users
		public static final String QUERY_ALL_CUSTOMERS = "SELECT userID,firstName,lastName,no,street,city,contact,email FROM user";
		
		//query to get selected user
		public static final String QUERY_GET_SELECTED_USER = "SELECT * FROM user WHERE userID = ?";
		
		//query to update selected user
		public static final String QUERY_UPDATE_SELECTED_USER = "UPDATE user "
				+ "SET firstName = ?, lastName = ?, password = ?, no = ?, street = ?, city = ?, contact = ? , email = ? , type = ?"
				+ "WHERE userID = ?";
		
		
		//query to get selected user by email
		public static final String QUERY_GET_LOGGED_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
		
		
		
		
		/*
		
		
		//query to get all the Dry and Clean Rates
		public static final String QUERY_ALL_DRY_CLEAN_RATES = "SELECT * FROM dry_clean_rates";
		
		
		
		
		
		
		
		//query to add wash_fold_order records
		public static final String QUERY_ADD_WASH_FOLD_ORDER = "INSERT INTO wash_fold_orders(order_id, rate_id, weight) VALUES(?,?,?)";
		
		//query to add dry_clean_order records
		public static final String QUERY_ADD_DRY_CLEAN_ORDER = "INSERT INTO dry_clean_orders(order_id, rate_id, quantity) VALUES(?,?,?)";
		
		//query to add wash_fold_status records
		public static final String QUERY_ADD_WASH_FOLD_STATUS = "INSERT INTO wash_fold_status(order_id, status) VALUES(?,?)";
		
		//query to add wash_fold_status records
		public static final String QUERY_ADD_DRY_CLEAN_STATUS = "INSERT INTO dry_clean_status(order_id, status) VALUES(?,?)";
		
		
		
		*/
		
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
		
		//column index 6
		public static final int COLUMN_INDEX_SIX = 6;
				
		//column index 7
		public static final int COLUMN_INDEX_SEVEN = 7;
				
		//column index 8
		public static final int COLUMN_INDEX_EIGHT = 8;
				
		//column index 9
		public static final int COLUMN_INDEX_NINE = 9;
		
		//column index 10
		public static final int COLUMN_INDEX_TEN = 10;
}
