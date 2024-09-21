package com.ibm.spring_boot_crud_operation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_crud_operation.dto.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

//	@Query

	public List<User> findByName(String name);
	
	public List<User> findByNameOrderByIdDesc(String name);
	
	@Query(value = "SELECT u FROM User u WHERE u.email=?1")  // ye jp Query l-jpql
	public User getUserByEmail(String email);
	
	@Query(value = "delete from user where dob=?1",nativeQuery = true)
	@Modifying   // 
	@Transactional // it will begin the transactional and end transactional
	public void deleteUserByDob(String date);
	
	
	@Query(value = "update  User u set u.name=?1 where u.dob=?2")
	@Modifying    
	@Transactional 
	public void updateUserNameByDob(String name, LocalDate dob);
	
	

}
