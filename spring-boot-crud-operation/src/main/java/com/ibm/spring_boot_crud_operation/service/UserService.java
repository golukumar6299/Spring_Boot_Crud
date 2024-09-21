package com.ibm.spring_boot_crud_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ibm.spring_boot_crud_operation.dao.UserDao;
import com.ibm.spring_boot_crud_operation.dto.User;
import com.ibm.spring_boot_crud_operation.response.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	private ResponseStructure<User> structure;
	
	public user saveUserService(User user) {
		
	}
	
	public ResponseStructure<List<User>> saveMultipleUserService(List<User> user){
		List<user> users = dao.saveMultipleUserDao(user);
		
		if(!users.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMassage("data saved");
			responseStructure.setData(users);
			return responseStructure;
		}
		else {
			
		}
	}
}
