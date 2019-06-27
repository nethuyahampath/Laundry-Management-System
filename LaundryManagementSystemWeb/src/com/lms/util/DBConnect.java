package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection con;
	private static Connection connection;

	public static Connection getDBConnection() throws SQLException {

		try {
			Class.forName(Constants.DRIVER_NAME);
			con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);

		} catch (Exception e) {
			System.out.println("Exception  : " + e);
		}

		return con;
	}

	public static Connection getDbConnection() throws SQLException {

		try {
			Class.forName(CommonConstant.DRIVER_NAME);
			connection = DriverManager.getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME,
					CommonConstant.DB_PASSWORD);

		} catch (Exception e) {
			System.out.println("Exception  : " + e);
		}

		return connection;
	}

}
