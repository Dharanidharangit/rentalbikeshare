package com.sampleproject.sampleproject.Response;

public class BikeReturnResponse {
	public double totalHours;
	public double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getRentalEnd() {
		return rentalEnd;
	}
	public void setRentalEnd(double rentalEnd) {
		this.rentalEnd = rentalEnd;
	}
	private double totalAmount;
	private double rentalEnd;


}
