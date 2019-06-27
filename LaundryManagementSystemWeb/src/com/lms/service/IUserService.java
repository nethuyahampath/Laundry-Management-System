package com.lms.service;

import java.util.ArrayList;

import com.lms.model.User;
import com.lms.model.Review;

public interface IUserService {

	public void addUser(User user);
	public ArrayList<User> getUsers();
	public User getTheUserByID(String userID);
	public User getTheUserByEmail(String email,String password);
	public User updateUser(String userID, User user);
	public void removeUser(String userID);
	
	//User reviews
	public void addReview( Review rev);
	public ArrayList<Review> getUserReviews();
	public ArrayList<User> getCustomers();
}
