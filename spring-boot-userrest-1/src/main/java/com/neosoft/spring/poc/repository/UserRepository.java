package com.neosoft.spring.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.spring.poc.model.User;




public interface UserRepository extends JpaRepository<User, Integer> {
	
List<User> findByName(String firstname);
	
	List<User> findBySurname(String firstname);
	
	List<User> findByPincode(String string);

	
	
	@Transactional
	@Modifying
	@Query("SELECT user From User user  WHERE user.deleted='false'")
	List<User>  findAllDeletedFalse();

	@Transactional
	@Modifying
	@Query("UPDATE User user SET user.deleted=:value WHERE user.id=:uid")
	void softDelete(int uid,boolean value);
	
	public List<User> findByNameOrSurnameOrPincode(String name,String surname,String pincode);


}
