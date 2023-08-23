package com.example.demo.day5proj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day5proj.model.UserModel;
import com.example.demo.day5proj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {

		@Autowired
		public UserService userv;
		@PostMapping("/PostUser")
		public UserModel postUser(@RequestBody UserModel ur)
		{
			return userv.saveUser(ur);
		}
		
		
//		//get mapping
		@GetMapping("/getUser")
		public List<UserModel> getUserInfo()
		{
			return userv.getUser();
			
		}
		
		//getUserByID

//	    @GetMapping("/users/{usersId}")
//
//	    public ResponseEntity<?> getUserById(@PathVariable int usersId){
//
//	    	Optional<UserModel>users=userv.getUserId(usersId);
//	    	if(users!=null)
//
//	    	{
//
//	    		return ResponseEntity.ok(users); //Return the user's data if available
//
//	    	}
//
//	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
//
//	    }
		
		
		
		//put mapping
//		@PutMapping("/updateModel")
//		public ProjModel updateProdtInfo(@RequestBody ProjModel p)
//		{
//			return pserv.updateProdt(h);
//		}
	    
	    @PutMapping("/updateUser")
	    public UserModel updateUserInfo(@RequestBody UserModel ua)

	    {

	    	return userv.updateUser(ua);

	    }

	    @PutMapping("/updateUserif/{id}")
	    public ResponseEntity<String> updateProdtInfor(@PathVariable int id,@RequestBody UserModel ua){

	    	   boolean updated=userv.updateUserif(id,ua);

	 			   if(updated)

	 			   {
	 				  return ResponseEntity.ok("User with ID "+id+" updated successfully"); //.ok means success
	 			   }

	 			   else

	 			   {
	 				  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" not found and not updated");
	 			   }
	 	   }


		
		
		//delete mapping using pathvariable
//		@DeleteMapping("/deleteUser/{id}")
//		public String removeProdt(@PathVariable("id") int uid)
//		{
//			pserv.deleteUser(uid);
//			return "User with Id "+uid+" is deleted";
//		}
		
		
	//	
	    
//		//delete mapping using reqparam
//		@DeleteMapping("/byReqParm")
//		public String removeRequestPam(@RequestParam("id")int id)
//		{
//			userv.deleteUser(id);
//			return "User with Id "+id+" is deleted";
//		}
		
		
		
		//delete using if condition
		@DeleteMapping("/deleteUserif/{id}")
		public ResponseEntity<String>deleteUserInfo(@PathVariable int id)
		{
			boolean deleted=userv.deleteUserif(id);
			if(deleted)
			{
				return ResponseEntity.ok("user with ID "+id+" deleted successfully");
				
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" not found");
			}
				
			
		}
		
	}

