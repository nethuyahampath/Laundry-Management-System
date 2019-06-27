package com.lms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lms.model.Review;
import com.lms.model.User;
import com.lms.util.CommonConstant;
import com.lms.util.DBConnect;

public class UserServiceImpl implements IUserService {

	
	
	
	/*private	String dburl ="jdbc:mysql://localhost:3306/laundary?useSSL=false";
	private	String username ="root";
	private	String password ="4123";*/
	
	Connection connection;
	PreparedStatement preparedStatement1,preparedStatement2,preparedStatement3,preparedStatement4,preparedStatement5,preparedStatement6;
	ResultSet resultSet;
	
	
	
	///////////////////////////////        ADD USER
	
	
	
	public void addUser(User user) {
		
		
		
		try {
			
			
			connection = DBConnect.getDbConnection();
			
			System.out.println("DB connection successful to: " + CommonConstant.DB_URL);
			
			
			
			preparedStatement1 = connection.prepareStatement(CommonConstant.QUERY_ADD_USER);
			
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_ONE, user.getUserID());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_TWO, user.getFirstName());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_THREE, user.getLastName());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_FOUR, user.getPassword());
			preparedStatement1.setInt(CommonConstant.COLUMN_INDEX_FIVE, user.getNo());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_SIX, user.getStreet());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_SEVEN, user.getCity());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_EIGHT, user.getContact());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_NINE, user.getEmail());
			preparedStatement1.setString(CommonConstant.COLUMN_INDEX_TEN, user.getType());
			
			
			preparedStatement1.execute();
			

		} catch (Exception e) {
			System.out.println( "Exception Add User : " + e );
		}
		
		
		
		
	}
	
	
	
	
	
	////////////////////////////////////////////////          GET USERS

	
	


	public ArrayList<User> getUsers() {
	
		//return UserList(null);
		
		
		
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			
			connection = DBConnect.getDBConnection();
			
			
			
			/*if (userID != null && !userID.isEmpty()) {
			
				preparedStatement = connection.prepareStatement("select * "
								+ "from user"
								+ "where user.userID = ?");
				preparedStatement.setString(1, userID);
			}*/
			
			/*if(userID == null) {*/
				preparedStatement2 = connection.prepareStatement(CommonConstant.QUERY_ALL_USERS);
					                    
			/*}*/
			
			
			resultSet = preparedStatement2.executeQuery();
	
			while (resultSet.next()) {
				User user = new User();
				user.setUserID(resultSet.getString(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				user.setNo(resultSet.getInt(5));
				user.setStreet(resultSet.getString(6));
				user.setCity(resultSet.getString(7));
				user.setContact(resultSet.getString(8));
				user.setEmail(resultSet.getString(9));
				user.setType(resultSet.getString(10));
				
				userList.add(user);
			}
	
		} catch (Exception e) {
			System.out.println( "Exception : " + e );
		} finally {
			
			try {
				if (preparedStatement2 != null) {
					preparedStatement2.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			}
		}
		
	return userList;

	}
	
	
	
	
	

	
	
	
		
		
	///////////////////         GET USER BY ID
	

	
	
	
	
	

	public User getTheUserByID(String userID) {

		//return UserList(userID).get(0);
		
		//private ArrayList<User> UserList(String userID) {

			//ArrayList<User> oneUserList = new ArrayList<User>();
		
		User user = new User();
		
			try {
				
				connection = DBConnect.getDBConnection();
				
				
				
				/*if (userID != null && !userID.isEmpty()) {*/
				
					preparedStatement3 = connection.prepareStatement(CommonConstant.QUERY_GET_SELECTED_USER);
					preparedStatement3.setString(CommonConstant.COLUMN_INDEX_ONE, userID);
			/*	}*/
				
				/*if(userID == null) {
					preparedStatement = connection.prepareStatement("select *"
							+ "from user");
						                    
				}*/
				
				
				resultSet = preparedStatement3.executeQuery();
	
				while (resultSet.next()) {
					//User user = new User();
					user.setUserID(resultSet.getString(1));
					user.setFirstName(resultSet.getString(2));
					user.setLastName(resultSet.getString(3));
					user.setPassword(resultSet.getString(4));
					user.setNo(resultSet.getInt(5));
					user.setStreet(resultSet.getString(6));
					user.setCity(resultSet.getString(7));
					user.setContact(resultSet.getString(8));
					user.setEmail(resultSet.getString(9));
					user.setType(resultSet.getString(10));
					
					//userList.add(user);
					
					
				}
		
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			} finally {
				
				try {
					if (preparedStatement3 != null) {
						preparedStatement3.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					System.out.println( "Exception : " + e );
				}
			}
			
		//return userList;
			
			return user;
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
	public User updateUser(String userID, User user) {

		
		/*if (userID != null && !userID.isEmpty()) {*/
			
			try {
				connection = DBConnect.getDBConnection();
				preparedStatement4 = connection.prepareStatement(CommonConstant.QUERY_UPDATE_SELECTED_USER);
				
				
				
				
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_ONE, user.getFirstName());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_TWO, user.getLastName());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_THREE, user.getPassword());
				preparedStatement4.setInt(CommonConstant.COLUMN_INDEX_FOUR, user.getNo());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_FIVE, user.getStreet());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_SIX, user.getCity());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_SEVEN, user.getContact());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_EIGHT, user.getEmail());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_NINE, user.getType());
				preparedStatement4.setString(CommonConstant.COLUMN_INDEX_TEN, user.getUserID());
				
				preparedStatement4.executeUpdate();
			
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			}  finally {
			
				try {
					if (preparedStatement4 != null) {
						preparedStatement4.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					System.out.println( "Exception : " + e );
				} 
			}
			
			return getTheUserByID(userID);
		}
		
		//*****
		
		
	/*}*/
	
	
	
	
	
	
	
	
	
	
	
	public void removeUser(String userID) {

		
		if (userID != null && !userID.isEmpty()) {
			
			try {
				connection = DBConnect.getDBConnection();
				preparedStatement5 = connection.prepareStatement("delete from user where user.userID = ?");
				
				
				
				preparedStatement5.setString(1, userID);
				
				preparedStatement5.executeUpdate();
			
			
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			} finally {
				
				try {
					if (preparedStatement5 != null) {
						preparedStatement5.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					System.out.println( "Exception : " + e );
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public User getTheUserByEmail(String email,String password) {

		//return UserList(userID).get(0);
		
		//private ArrayList<User> UserList(String userID) {

			//ArrayList<User> oneUserList = new ArrayList<User>();
		
		User user = new User();
		
			try {
				
				connection = DBConnect.getDBConnection();
				
				
				
				/*if (userID != null && !userID.isEmpty()) {*/
				
					preparedStatement6 = connection.prepareStatement(CommonConstant.QUERY_GET_LOGGED_USER_BY_EMAIL);
					preparedStatement6.setString(CommonConstant.COLUMN_INDEX_ONE, email);
			/*	}*/
				
				/*if(userID == null) {
					preparedStatement = connection.prepareStatement("select *"
							+ "from user");
						                    
				}*/
				
				
				resultSet = preparedStatement6.executeQuery();
	
				while (resultSet.next()) {
					//User user = new User();
					user.setUserID(resultSet.getString(1));
					user.setFirstName(resultSet.getString(2));
					user.setLastName(resultSet.getString(3));
					user.setPassword(resultSet.getString(4));
					user.setNo(resultSet.getInt(5));
					user.setStreet(resultSet.getString(6));
					user.setCity(resultSet.getString(7));
					user.setContact(resultSet.getString(8));
					user.setEmail(resultSet.getString(9));
					user.setType(resultSet.getString(10));
					
					//userList.add(user);
					
					
				}
		
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			} finally {
				
				try {
					if (preparedStatement6 != null) {
						preparedStatement6.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					System.out.println( "Exception : " + e );
				}
			}
			
		//return userList;
			
				return user;
			
		
		
	}
	
	
public ArrayList<User> getCustomers() {
		
		//return UserList(null);
		
		
		
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			
			connection = DBConnect.getDbConnection();
			
			
			
			/*if (userID != null && !userID.isEmpty()) {
			
				preparedStatement = connection.prepareStatement("select * "
								+ "from user"
								+ "where user.userID = ?");
				preparedStatement.setString(1, userID);
			}*/
			
			/*if(userID == null) {*/
				preparedStatement2 = connection.prepareStatement(CommonConstant.QUERY_ALL_CUSTOMERS);
					                    
			/*}*/
			
			
			resultSet = preparedStatement2.executeQuery();
	
			while (resultSet.next()) {
				User user = new User();
				user.setUserID(resultSet.getString(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setNo(resultSet.getInt(4));
				user.setStreet(resultSet.getString(5));
				user.setCity(resultSet.getString(6));
				user.setContact(resultSet.getString(7));
				user.setEmail(resultSet.getString(8));
				
				
				userList.add(user);
			}
	
		} catch (Exception e) {
			System.out.println( "Exception : " + e );
		} finally {
			
			try {
				if (preparedStatement2 != null) {
					preparedStatement2.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			}
		}
		
	return userList;

	}
	
	
	
	
	
	
	
	
	
	
	/*
	
	private ArrayList<User> UserList(String userID) {

		ArrayList<User> userList = new ArrayList<User>();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(dburl, username, password);
			
			
			
			if (userID != null && !userID.isEmpty()) {
			
				preparedStatement = connection.prepareStatement("select * "
								+ "from user"
								+ "where user.userID = ?");
				preparedStatement.setString(1, userID);
			}
			
			if(userID == null) {
				preparedStatement = connection.prepareStatement("select *"
						+ "from user");
					                    
			}
			
			
			resultSet = preparedStatement.executeQuery();
	
			while (resultSet.next()) {
				User user = new User();
				user.setUserID(resultSet.getString(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				user.setNo(resultSet.getInt(5));
				user.setStreet(resultSet.getString(6));
				user.setCity(resultSet.getString(7));
				user.setContact(resultSet.getString(8));
				user.setEmail(resultSet.getString(9));
				
				userList.add(user);
			}
	
		} catch (Exception e) {
			System.out.println( "Exception : " + e );
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				System.out.println( "Exception : " + e );
			}
		}
		
	return userList;

	}*/
	
	
	//User Reviews
	public void addReview( Review rev) {
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement1 = connection.prepareStatement("INSERT INTO review(review_id, user_id, fname, grade,date, comment) VALUES(?,?,?,?,?,?)");
			
			preparedStatement1.setString(1, rev.getReviewID());
			preparedStatement1.setString(2, rev.getUserID());
			preparedStatement1.setString(3, rev.getFname());
			preparedStatement1.setString(4, rev.getGrade());
			preparedStatement1.setString(5, rev.getDate());
			preparedStatement1.setString(6, rev.getComment());
			
			preparedStatement1.execute();
			
		}catch( Exception e ) {
			System.out.println("Exception in adding  review : " + e );
		}
	}

	public ArrayList<Review> getUserReviews(){
		
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement1  = connection.prepareStatement("SELECT * FROM review");
	
			resultSet = preparedStatement1.executeQuery();
			
			while( resultSet.next() ) {
				Review rev = new Review();
				
				rev.setReviewID(resultSet.getString(1));
				rev.setUserID(resultSet.getString(2));
				rev.setFname(resultSet.getString(3));
				rev.setGrade(resultSet.getString(4));
				rev.setDate(resultSet.getString(5));
				rev.setComment(resultSet.getString(6));
				
				reviewList.add(rev);
			}
			
		}catch(Exception e ) {
			System.out.println("Exception in review display : " +  e );
		}
		
		return reviewList;
	}
	
	
}
