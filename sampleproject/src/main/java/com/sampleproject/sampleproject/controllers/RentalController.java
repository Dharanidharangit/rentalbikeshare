package com.sampleproject.sampleproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.sampleproject.Response.RentalHistoryResponse;
import com.sampleproject.sampleproject.entity.RentalEntity;
import com.sampleproject.sampleproject.requests.RentalRequest;
import com.sampleproject.sampleproject.service.RentalService;


@RestController
@RequestMapping("")
public class RentalController {
	@Autowired
	private RentalService rentalservice;
	
	@PostMapping("api/rentalbooking")
	public String RentalBooking(@RequestBody RentalRequest rent)
	{
		return rentalservice.rentalbook(rent);
		
	}
	@PostMapping("api/bikereturn/{rentalid}")
	public String RentalReturn(@PathVariable("rentalid") Long rentalid)
	{
		return rentalservice.bikereturn(rentalid);
	}
	@GetMapping("api/Getallrentalrecords")
	public List<RentalEntity> Getallrentalrecords()
	{
		return rentalservice.rentalrecords();
		
	}
	@GetMapping("api/rentalhistoryforspecificuser/{userid}")
	public List<RentalHistoryResponse> rentalhistoryforspecificuser(@PathVariable("userid") Long userid)
	{
		return rentalservice.rentallrecordsbyid(userid);
	}
	@DeleteMapping("api/deleterentalrecordbyuserid/{userid}")
	public 	String deleterentalrecord(@PathVariable("userid") Long userid)
	{
		return rentalservice.deleterentalecord(userid);
	}

	

}
