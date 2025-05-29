package com.sampleproject.sampleproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Rentalbike")
public class RentalEntity {
	
	/*
	 * rentalId Long Primary Key (auto-generated) userId Long Foreign Key
	 * (UserEntity) bikeId Long Foreign Key (BikeEntity) rentalStart DateTime Time
	 * when rental started rentalEnd DateTime Time when bike was returned totalHours
	 * Double Hours rented totalAmount Double Total cost = hours × hourly rate
	 * status String Ongoing / Completed / Cancelled
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rentalId;
	

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bikeid", nullable = false)
    private BikeEntity bike;
    
    @Column(nullable= false)
    private LocalDateTime rentalStart;
    
    @Column(nullable= true)
    private LocalDateTime rentalEnd;
	/*
	 * LocalDateTime is a class from Java's java.time package (Java 8+).
	 * 
	 * It represents a date and time without a time zone.
	 * 
	 * Example value: 2025-05-07T14:30 (May 7, 2025 at 2:30 PM).my
	 */

    private Double totalHours;
    public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public BikeEntity getBike() {
		return bike;
	}

	public void setBike(BikeEntity bike) {
		this.bike = bike;
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

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Double totalAmount;

    private String status;

	/*
	 * '2025-05-04 00:42:41.320422' is a timestamp representing a specific date and
	 * time, including fractional seconds (microseconds). Here's how it's broken
	 * down:
	 * 
	 * 🧩 Breakdown: 2025-05-04 → Date (May 4, 2025)
	 * 
	 * 00:42:41 → Time (12:42 AM and 41 seconds)
	 * 
	 * .320422 → Microseconds (320,422 microseconds or ~0.32 seconds)
	 */
}
