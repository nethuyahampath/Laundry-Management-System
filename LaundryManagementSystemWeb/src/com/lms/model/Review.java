package com.lms.model;

public class Review {
	private String reviewID;
	private String userID;
	private String grade;
	private String date;
	private String comment;
	private String fname;
	
	public void setReviewID( String reviewID ) {
		this.reviewID =  reviewID;
	}
	
	public void setUserID( String userID ) {
		this.userID = userID;
	}
	
	public void setGrade( String grade ) {
		this.grade = grade;
	}
	
	public void setDate( String date ) {
		this.date = date;
	}
	
	public void setComment( String comment ) {
		this.comment = comment;
	}
	
	public void setFname( String fname ) {
		this.fname = fname;
	}
	
	public String getReviewID() {
		return reviewID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public String getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}
	
	public String getFname() {
		return fname;
	}
}


