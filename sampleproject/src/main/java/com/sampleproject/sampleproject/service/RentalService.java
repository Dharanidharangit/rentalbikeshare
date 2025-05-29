package com.sampleproject.sampleproject.service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleproject.sampleproject.Response.BikeReturnResponse;
import com.sampleproject.sampleproject.Response.RentalHistoryResponse;
import com.sampleproject.sampleproject.entity.BikeEntity;
import com.sampleproject.sampleproject.entity.RentalEntity;
import com.sampleproject.sampleproject.entity.UserEntity;
import com.sampleproject.sampleproject.repository.BikeRepository;
import com.sampleproject.sampleproject.repository.RentalRepository;
import com.sampleproject.sampleproject.repository.UserRepository;
import com.sampleproject.sampleproject.requests.RentalRequest;

@Service
public class RentalService {
	@Autowired
	private RentalRepository rentalrepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private BikeRepository bikerepository;
	
	public String rentalbook(RentalRequest rent)
	{
		Optional<UserEntity> userdata=userrepository.findById(rent.getUserid());
		Optional<BikeEntity> bikedata=bikerepository.findById(rent.getBikeid());
		/*
		 * // Validate the rental request for null values if (rent.getUserid() == null
		 * || rent.getBikeid() == null) { return "User ID and Bike ID must not be null";
		 * }
		 */
		if(userdata.isEmpty())
			return "userid not found";
		if(bikedata.isEmpty())
			return "bikeid not found";
		
		BikeEntity bike=bikedata.get();
		if(!bike.getStatus().equals("Available"))
			return "Bike is not available";
		
		bike.setStatus("Booked");
		bikerepository.save(bike);
		
		RentalEntity rentaldata=new RentalEntity();
		rentaldata.setUser(userdata.get());
		rentaldata.setBike(bikedata.get());
		rentaldata.setStatus("ongoing");
		rentaldata.setRentalStart(LocalDateTime.now());
		rentalrepository.save(rentaldata);
		
		
		return "Bike Booked Succesfully";
	}
	public String bikereturn(Long rentalid)
	{
		Optional<RentalEntity> optrental=rentalrepository.findById(rentalid);
		if(optrental.isEmpty())
			return "rentalid not found";
		RentalEntity rental=optrental.get();
		
		//totalamount,totalhours
		LocalDateTime enddatetime=LocalDateTime.now();
		
		//calculating total hour
		long minutes=Duration.between(rental.getRentalStart(), enddatetime).toMinutes();
		double Hour=minutes/60.0;
		
		//updating bike status
		BikeEntity bikes=rental.getBike();
		bikes.setStatus("Available");
		bikerepository.save(bikes);
		
		//calculating amount
		rental.setTotalHours(Hour);
		double amount= Hour * rental.getBike().getHourlyRate();
		rental.setTotalAmount(amount);
		rental.setRentalEnd(enddatetime);
		rental.setStatus("Completed");
		rentalrepository.save(rental);
	
		
	
		return "Bike returned successfully with amount =" +amount+",totalhoursused="+Hour+",enddatetime="+enddatetime;
	}
	public List<RentalEntity> rentalrecords(){
		
		List<RentalEntity> records=rentalrepository.findAll();
		return records;
		
	}
	public List<RentalHistoryResponse> rentallrecordsbyid(Long userid)
	{
		List<RentalEntity> rentals=rentalrepository.findByUserUserid(userid);
		
		List<RentalHistoryResponse> history=new ArrayList<>();
		for(RentalEntity rental:rentals)
		{
			history.add(new RentalHistoryResponse(
					rental.getRentalId(),
					rental.getRentalStart(),
					rental.getRentalEnd(),
					rental.getTotalAmount()!=null ?rental.getTotalAmount():0.0,
					rental.getTotalHours()!=null ?rental.getTotalHours():0.0
					));
		}
		
		
		return history;
	}
	@Transactional
	public String deleterentalecord(Long userid)
	{
		//Optional<RentalEntity> data=rentalrepository.findById(userid);
		long count=rentalrepository.deleteByUserUserid(userid);
		return "deleted"+count+" rows successfully";
		
	}

}
