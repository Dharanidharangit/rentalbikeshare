package com.sampleproject.sampleproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sampleproject.sampleproject.entity.BikeEntity;
import com.sampleproject.sampleproject.repository.BikeRepository;

@Service
public class BikeService {
	@Autowired
	private BikeRepository bikerepository;
	public BikeEntity addbikes(BikeEntity bike)
	{
		
		return bikerepository.save(bike);
	}
	public String bikeupdate(Long bikeid,BikeEntity bike)
	{
		Optional<BikeEntity> bikedata=bikerepository.findById(bikeid);
		if(!bikedata.isEmpty())
			return "bikeid does nor exits";
		
		BikeEntity bikesdata=bikedata.get();
		bikesdata.setType(bike.getType());
		bikesdata.setStatus(bike.getStatus());
		bikesdata.setModel(bike.getModel());
		bikesdata.setLocation(bike.getLocation());
		bikesdata.setIsActive(bike.getIsActive());
		bikesdata.setHourlyRate(bike.getHourlyRate());
		bikerepository.save(bikesdata);
		return "bikedata updated succesfully";
	}
	public BikeEntity getbike(Long bikeid)
	{
		Optional<BikeEntity> bikedta=bikerepository.findById(bikeid);
		if(!bikedta.isPresent())
			throw new RuntimeException("bike id not found");
		
		return bikedta.get();
	}
	public List<BikeEntity> getallbikes()
	{
		List<BikeEntity> bikedatas=bikerepository.findAll();
		return bikedatas;
	}
	
	public String deletebike(Long bikeid)
	{
		if(!bikerepository.existsById(bikeid))
			return "bikeid not found";
		
		bikerepository.deleteById(bikeid);
		return "deleted succesfully";
	}
	

}
