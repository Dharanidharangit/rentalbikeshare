package com.sampleproject.sampleproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleproject.sampleproject.entity.UserEntity;
import com.sampleproject.sampleproject.repository.UserRepository;
import com.sampleproject.sampleproject.requests.loginrequest;

@Service
public class UserService {
   @Autowired
   private UserRepository userrepository;
	public String userregister(UserEntity userss)
	{
		if(userrepository.existsByEmail(userss.getEmail()))
		{
			return "user already exists";
		}
		userrepository.save(userss);
		return "registered succesfully";
	}
	public String userlogin(loginrequest userlogin)
	{
		UserEntity userdata=userrepository.findByEmail(userlogin.getEmail());
		if(userdata==null)
		{
			return "user not found";
		}
		if(!userlogin.getPassword().equals(userdata.getPassword()))
		{
			return "password incorrect";
		}
		/*
		 * if(!userlogin.getPassword().equals(userdata.getEmail())) { return
		 * "logged in succesfully"; }
		 */
		return "log in succesfully";
	}
	public UserEntity userdetail(Long userid)
	{
		
			Optional<UserEntity> userdata=userrepository.findById(userid);
			if(userdata.isEmpty())
			{
				throw new RuntimeException("User not found"); 
				
				
			}
		
		return userdata.get();
	}
	public List<UserEntity> alluserdetail()
	{
		List<UserEntity> datas=userrepository.findAll();
		if(datas.isEmpty())
			throw new RuntimeException("User not found");
		return datas;
	}
	
	public String updateuserdata(Long userid,UserEntity use)
	{
		Optional<UserEntity> userdatas=userrepository.findById(userid);
		if(!userdatas.isPresent())
		{
			return "user not found";
			
		}
		
		UserEntity data=userdatas.get();
		data.setEmail(use.getEmail());
		data.setFull_name(use.getFull_name());
		data.setPhone(use.getPhone());
		data.setPassword(use.getPassword());
		userrepository.save(data);
	
		
		return "updated succesfully";
	}
	public String deletebyuserid(Long userid)
	{
		Optional<UserEntity> usedata=userrepository.findById(userid);
		if(!usedata.isPresent())
		{
			return "user not found";
		}
		userrepository.deleteById(userid);
		return "deleted suceesfully";
	}
	
}
