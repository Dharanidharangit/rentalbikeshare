package com.sampleproject.sampleproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sampleproject.sampleproject.entity.BikeEntity;
import com.sampleproject.sampleproject.service.BikeService;

@RestController
@RequestMapping("")
public class BikesController {

    @Autowired
    private BikeService bikeservice;

    // POST API to add a bike
    @PostMapping("api/bikeadd")
    public BikeEntity addbike(@RequestBody BikeEntity bike) {
        return bikeservice.addbikes(bike);
    }

    // PUT API to update a bike by bike ID
    @PutMapping("api/updatebike/{bikeid}")
    public String updatebike(@PathVariable("bikeid") Long bikeid,@RequestBody BikeEntity bike)
    {
    	return bikeservice.bikeupdate(bikeid, bike);
    }
    
    @GetMapping("api/getdatabybikeid/{bikeid}")
    public BikeEntity Getbikedata(@PathVariable("bikeid") Long bikeid)
    {
    	
    	return bikeservice.getbike(bikeid);
    }
    
    @GetMapping("api/getallbike/{bikeid}")
    public List<BikeEntity> Getallbikedata()
    {
    	return bikeservice.getallbikes();
    	
    }
    @DeleteMapping("api/Deletebike/{bikeid}")
    public String deletebike(@PathVariable("bikeid") Long bikeid)
    {
    	return bikeservice.deletebike(bikeid);
    	
    }
 
}

