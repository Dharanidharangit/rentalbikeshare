package com.sampleproject.sampleproject.Response;

import java.time.LocalDateTime;

public class RentalHistoryResponse {
	
    
	public Long getRentalId() {
		return rentalId;
	}
	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}
	public LocalDateTime getRentalStart() {
		return rentalStart;
	}
	public void setRentalStart(LocalDateTime rentalStart) {
		this.rentalStart = rentalStart;
	}
	public LocalDateTime getRentalEnd() {
		return rentalEnd;
	}
	public void setRentalEnd(LocalDateTime rentalEnd) {
		this.rentalEnd = rentalEnd;
	}
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
	private Long rentalId;
	public RentalHistoryResponse(Long rentalId, LocalDateTime rentalStart, LocalDateTime rentalEnd, double totalHours,
			double totalAmount) {
		super();
		this.rentalId = rentalId;
		this.rentalStart = rentalStart;
		this.rentalEnd = rentalEnd;
		this.totalHours = totalHours;
		this.totalAmount = totalAmount;
	}
	private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;
    private double totalHours;
    private double totalAmount;



}

