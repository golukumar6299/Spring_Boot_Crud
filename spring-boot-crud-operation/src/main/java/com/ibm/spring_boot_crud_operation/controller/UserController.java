package com.ibm.spring_boot_crud_operation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_operation.dao.UserDao;
import com.ibm.spring_boot_crud_operation.dto.User;

@RestController  //to create rest webservices and api
public class UserController {
	@Autowired
	private UserDao dao;

	@RequestMapping(value ="/getTodaysDate")
 public String getTodaysDate() {
	return LocalDate.now()+" ";
	 }
	
	@GetMapping(value ="/addition/{a}/{b}")
 public int  getAddition(@PathVariable int a, @PathVariable int b) {
	return a+b;
	
 
 }
	@PostMapping(value = "/saveUser")
	public User saveUserController(@RequestBody User user) {
		
		System.out.println(user);
		
		return dao.saveUserDao(user);
		
	}
	
	@GetMapping(value ="/findById/{id}")
	public User findUserByIdController(@PathVariable int id) {
		return dao.findUserByIdDao(id);
	}
	
	@GetMapping(value ="/findAllUser")
	public List<User> findAllUserController(){
		return dao.findAllUserDao();
	}
	@GetMapping(value ="/saveMultipleUser")
	public List<User> saveMultipleController(@RequestBody List<User> user){
		return dao.saveMultipleUserDao(user);
	
}
	@GetMapping(value ="/findUserByName/{name}")
	public List<User>findByNameController(@PathVariable String name){
		return dao.findByNameDao(name);
	}
	@GetMapping(value ="/findUserByNameOrderByAsc/{name}")
	public List<User> findByNameOrderByNameAscDao(String name){
		return dao.findByNameOrderByNameAscDao(name);
		}
	
	@GetMapping(value ="/findUserBYEmail/{email}")
	  public User getUserByEmailController(@PathVariable String email) {
		return dao.getUserByEmailDao(email);
	}
	
	@GetMapping(value ="/deleteUser/{date}")
       public ResponseEntity<String> deleteUserByDob(@PathVariable LocalDate date){
    	   boolean b= dao.deleteUserBYDobDao(date);
    	   if(b) {
    		   return new  ResponseEntity<String>("Date deleted", HttpStatus.ACCEPTED);
    	   }else {
    		   return new ResponseEntity<String>("given dob is not found/not valid" ,HttpStatus.NOT_ACCEPTABLE);
    	   }
       }
	
}
