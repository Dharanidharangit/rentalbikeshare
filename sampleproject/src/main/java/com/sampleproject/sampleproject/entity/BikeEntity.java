package com.sampleproject.sampleproject.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="bike")
public class BikeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bikeid;
	public Long getBikeid() {
		return bikeid;
	}
	public void setBikeid(Long bikeid) {
		this.bikeid = bikeid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	   // @Positive(message = "Hourly rate must be greater than 0")
    @NotNull(message = "model is required")
	private String model;       // e.g., "Honda CB350"
    
    @NotNull(message = "type is required")
	private String type;        // e.g., "Electric", "Scooter", "Mountain"
    
    @NotNull(message = "status is required")
	private String status;      //Available, Booked, Maintenance
    
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull(message = "location is required")
	private String location;    // e.g., "Station A", GPS address, etc.
    
    @Positive(message = "hourlyRate should be greater than zero")
	private Double hourlyRate;     // Rental price per hour
    
    @NotNull(message = "isActive is required")
	private Boolean isActive;     // To soft-delete bikes if needed
	

}
