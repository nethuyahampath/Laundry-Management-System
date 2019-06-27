package com.lms.service;

import java.util.ArrayList;
import java.sql.*;

import com.lms.model.WashFoldRates;
import com.lms.model.DryCleanRates;
import com.lms.util.DBConnect;
import com.lms.util.Constants;

public class RatesServiceImpl implements IRatesService {

	private static Connection con;
	
	private static PreparedStatement prepStmt;
	
	private static ResultSet resultSet;
	
	public ArrayList<WashFoldRates> getWashFoldRates() {

		ArrayList<WashFoldRates> ratesList = new ArrayList<WashFoldRates>();
		try {

			/*Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/laundry_management_system?useSSL=false", "root", "sliit");*/
			
			con = DBConnect.getDBConnection();
			

			prepStmt = con.prepareStatement(Constants.QUERY_ALL_WASH_FOLD_RATES);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {

				WashFoldRates rates = new WashFoldRates();

				rates.setRateID(resultSet.getString(Constants.COLUMN_INDEX_ONE));
				rates.setRatePackage(resultSet.getString(Constants.COLUMN_INDEX_TWO));
				rates.setSmallWeightPrice(resultSet.getInt(Constants.COLUMN_INDEX_THREE));
				rates.setMediumWeightPrice(resultSet.getInt(Constants.COLUMN_INDEX_FOUR));
				rates.setLargeWeightPrice(resultSet.getInt(Constants.COLUMN_INDEX_FIVE));

				ratesList.add(rates);
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ratesList;

	}

	public ArrayList<DryCleanRates> getDryCleanRates() {

		ArrayList<DryCleanRates> ratesList = new ArrayList<DryCleanRates>();
		try {

			/*Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/laundry_management_system?useSSL=false", "root", "sliit");*/

			con = DBConnect.getDBConnection();
			
			prepStmt = con.prepareStatement(Constants.QUERY_ALL_DRY_CLEAN_RATES);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {

				DryCleanRates rates = new DryCleanRates();

				rates.setRateID(resultSet.getString(Constants.COLUMN_INDEX_ONE));
				rates.setRateItem(resultSet.getString(Constants.COLUMN_INDEX_TWO));
				rates.setPricePerUnit(resultSet.getInt(Constants.COLUMN_INDEX_THREE));

				ratesList.add(rates);
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return ratesList;

	}
	
	//admin and staff
	
public void addWashFoldRates( WashFoldRates wfR  ) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection(Constants.DB_URL,Constants.DB_USERNAME,Constants.DB_PASSWORD);
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO wash_fold_rates(rate_id,package,small_weight_price,medium_weight_price,large_weight_price) VALUES(?,?,?,?,?)");
			
			
			stmt.setString(1, wfR.getRateID());
			stmt.setString(2, wfR.getRatePackage());
			stmt.setInt(3, wfR.getSmallWeightPrice());
			stmt.setInt(4, wfR.getMediumWeightPrice());
			stmt.setInt(5, wfR.getLargeWeightPrice());
			
			stmt.execute(); 
			
		}catch(Exception e) {
			System.out.println("Exeption " +  e  );
		}
		
	}
	
	
	
	public void addDryCleanRates(DryCleanRates dcR) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection(Constants.DB_URL,Constants.DB_USERNAME,Constants.DB_PASSWORD);
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO dry_clean_rates(rate_id,item,price_per_unit) VALUES(?,?,?)");
			
			stmt.setString(1, dcR.getRateID());
			stmt.setString(2, dcR.getRateItem());
			stmt.setInt(3, dcR.getPricePerUnit());
			
			stmt.execute();
			
			
		}catch(Exception e) {
			System.out.println("Execption " + e);
		}
	}
	
	
	public void updateWashFoldRates(String rateID, WashFoldRates wfR) {
		
		
		try {
			
			con = DBConnect.getDBConnection();
			prepStmt =  con.prepareStatement("UPDATE wash_fold_rates SET package = ?, small_weight_price = ?, medium_weight_price = ?, large_weight_price = ?  WHERE rate_id = ?");
			
			prepStmt.setString( 1, wfR.getRatePackage());
			prepStmt.setInt(2, wfR.getSmallWeightPrice());
			prepStmt.setInt(3, wfR.getMediumWeightPrice());
			prepStmt.setInt(4, wfR.getLargeWeightPrice());
			prepStmt.setString(5, wfR.getRateID());
			
			prepStmt.execute();
			
		}catch(Exception e) {
			System.out.println("Exception in wash fold : " + e );
		}
	}
	
	public void updateDryCleanRates(String rateID, DryCleanRates dcR) {
		
		try {
			
			con = DBConnect.getDBConnection();
			prepStmt = con.prepareStatement("UPDATE dry_clean_rates SET item = ?, price_per_unit = ? WHERE rate_id = ?");
			
			prepStmt.setString(1, dcR.getRateItem());
			prepStmt.setInt(2, dcR.getPricePerUnit());
			prepStmt.setString(3, dcR.getRateID());
			
			prepStmt.execute();
			
		}catch(Exception e) {
			System.out.println("Exception in Dry Clean : " + e);
		}
	}
	
	public void deleteWFRates(String rateID) {
		
		try {
			
			con = DBConnect.getDBConnection();
			prepStmt =  con.prepareStatement("DELETE FROM wash_fold_rates  WHERE rate_id = ?");
			prepStmt.setString(1, rateID);
			
			prepStmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
	}
	
	public void deleteDCRates(String rateID) {
		
		try {
			
			con = DBConnect.getDBConnection();
			prepStmt = con.prepareStatement("DELETE FROM dry_clean_rates  WHERE rate_id = ?");
			prepStmt.setString(1, rateID);
			
			prepStmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
	}
	
	
}
