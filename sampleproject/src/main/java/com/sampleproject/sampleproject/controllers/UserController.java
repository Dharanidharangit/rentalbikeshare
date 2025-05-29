package com.sampleproject.sampleproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.sampleproject.entity.UserEntity;
import com.sampleproject.sampleproject.requests.loginrequest;
import com.sampleproject.sampleproject.service.UserService;

@RestController
@RequestMapping("")
public class UserController {
	 @Autowired
	 private UserService userservice;
	
	  @PostMapping("/api/Userregister") 
	  public String getUsers(@RequestBody UserEntity userss)
	  {
		  
		  return userservice.userregister(userss) ;
	  }
	  @PostMapping("/api/Userlogin") 
	  public String getlogin(@RequestBody loginrequest login)
	  {
		  
		  return userservice.userlogin(login);	 
	  }
	  @GetMapping("api/getusersbyid/{userid}")
	  public UserEntity getuserdetail(@PathVariable("userid") Long userid)
	  {
		  return userservice.userdetail(userid);
	  }
	  @GetMapping("api/getusers")
	  public List<UserEntity> getalluser()
	  {
		  return userservice.alluserdetail();
	  }
	  @PutMapping("api/update/{userid}")
	  public String updateuser(@PathVariable("userid") Long userid,@RequestBody UserEntity use)
	  {
		  return userservice.updateuserdata(userid, use);
		  
	  }
	  @DeleteMapping("api/deleteuserbyid/{userid}")
	  public String deleteusernbyid(@PathVariable("userid") Long userid)
      {
		return userservice.deletebyuserid(userid);  
	  }
	  
}
