package com.ibm.spring_boot_crud_operation.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_crud_operation.dto.User;
import com.ibm.spring_boot_crud_operation.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	public User saveUserDao(User user) {
		return repository.save(user);
		
	}
	
	
	
	public List<User> saveMultipleUserDao(List<User> user){
		return repository.saveAll(user);
	}
	
	public User findUserByIdDao(int id) {
		
		
		Optional<User> optional=repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public java.util.List<User> findAllUserDao(){
		return repository.findAll();
	}
	
	public List<User> findByNameDao(String name){
	return repository.findByName(name);
	}
	
	public List<User> findByNameOrderByNameAscDao(String name){
		return repository.findByNameOrderByIdDesc(name);
		}
	
	public User getUserByEmailDao(String email) {
		return repository.getUserByEmail(email);
	}
	
	public boolean deleteUserBYDobDao(LocalDate date) {
		try {
			repository.deleteUserByDob(date);
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUserBYDobDao(String date) {
		try {
			repository.deleteUserByDob(date);
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
//@Component, @repository, @service class ya interface ko spring container ka part bana deta hai..