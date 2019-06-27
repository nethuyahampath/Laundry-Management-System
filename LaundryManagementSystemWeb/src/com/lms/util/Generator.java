package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import com.lms.util.Constants;
import com.lms.util.DBConnect;

public class Generator {

	private static Connection con;
	private static PreparedStatement prepStmt;
	private static ResultSet resultSet;
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static String generateWashFoldOrdersID() {

		String ID = "";

		try {

			con = DBConnect.getDBConnection();
			con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);

			prepStmt = con.prepareStatement(Constants.QUERY_MAX_WF_ORDER_ID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(Constants.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "WFO520";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "WFO" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	public static String generateDryCleanOrdersID() {

		String ID = "";

		try {

			con = DBConnect.getDBConnection();
			con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);

			prepStmt = con.prepareStatement(Constants.QUERY_MAX_DC_ORDER_ID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(Constants.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "DCO520";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "DCO" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);
		
		return newDate;
	}
	
	public static String generatePaymentID() {

		String ID = "";

		try {

			con = DBConnect.getDBConnection();
			con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);

			prepStmt = con.prepareStatement(Constants.QUERY_MAX_PAYMENT_ID);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(Constants.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "P140";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "P" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	public static String generateUserIDs() {

		String ID = "";

		try {

			connection = DBConnect.getDbConnection();
			connection = DriverManager.getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);

			preparedStatement = connection.prepareStatement(CommonConstant.QUERY_MAX_USER_ID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(CommonConstant.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "U10001";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "U" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	public static String generateAdminIDs() {

		String ID = "";

		try {

			connection = DBConnect.getDbConnection();
			connection = DriverManager.getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);

			preparedStatement = connection.prepareStatement(CommonConstant.QUERY_MAX_ADMIN_ID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(CommonConstant.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "A10001";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "A" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	public static String generateReviewIDs() {

		String ID = "";

		try {

			connection = DBConnect.getDbConnection();
			connection = DriverManager.getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);

			preparedStatement = connection.prepareStatement(Constants.QUERY_MAX_REVIEW_ID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ID = resultSet.getString(CommonConstant.COLUMN_INDEX_ONE);
			}

			if (ID == null) {
				ID = "REV201";
			} else {
				String newString = ID.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(newString);
				++num;

				ID = "REV" + num;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ID;
	}
	
	
}
