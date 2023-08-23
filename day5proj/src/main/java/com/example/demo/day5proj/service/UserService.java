package com.example.demo.day5proj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

//import com.example.demo.day5proj.controller.Sample;
import com.example.demo.day5proj.model.UserModel;

import com.example.demo.day5proj.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {

	
	@Autowired
	public UserRepo urepo;
	
	//post data
	public UserModel saveUser(UserModel u)
	{
		return urepo.save(u);
	}
	
	
	//get data
	public List<UserModel> getUser()
	{
		return urepo.findAll();
	}
	
//	
//	//getUserByID
//	
//	public Optional<UserModel>getUserId(int usersId)
//	
//	{
//		
//		Optional<UserModel>users=urepo.findById(usersId);
//		
//		if(users.isPresent())
//			
//		{
//			return users;
//		}
//		
//		return null;
//		
//	}
	
	//update the data if id present
	
	public boolean updateUserif(int userId,UserModel um) {
		
		if(urepo.existsById(userId)) {
			
			urepo.save(um);
			
			return true;
			
		}
		
		return false;
		
	}
	
	//update data
	public UserModel updateUser(UserModel um)
	{
		return urepo.saveAndFlush(um);
	}
	
	
	
	
	//delete if id is present
	public boolean deleteUserif(int usersId)
	{
		if(urepo.existsById(usersId))
		{
			urepo.deleteById(usersId);
			return true;
		}
		return false;
	}
	
	
	//delete data
	public void deleteUser(int user_id)
	{
		System.out.println("Deleted");
		urepo.deleteById(user_id);
		
	}
   
	
}





