package com.neosoft.spring.poc.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neosoft.spring.poc.model.User;
import com.neosoft.spring.poc.repository.UserRepository;



@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> getSoftUsers(){
		return userRepo.findAllDeletedFalse();
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User addUsers(User user) {
		return userRepo.save(user);
	}

	public void deleteUsersById(int id) {
		userRepo.deleteById(id);
		
	}

	public Optional<User> getUsersById(int id) {
		
		return userRepo.findById(id);
	}

	public User update(User user) {
		
		return userRepo.save(user);
	}

	public List<User> getUsersByName(String name) {
		
		return userRepo.findByName(name);
	}

	public List<User> getUsersBySurName(String surname) {
		
		return userRepo.findBySurname(surname);
	}
	


	public List<User> getUsersByPincode(String pincode) {
		
		return userRepo.findByPincode(pincode);
	}
	
	public Optional<User> getUsersByPhoneno(long phoneno) {
		 return userRepo.findByPhoneno(phoneno);
		
	}
	
	
	
	public List<User> sortByDoj() {
		
	 return userRepo.findAll().stream().sorted((o1, o2) -> o1.getDoj().
				compareTo(o2.getDoj())).collect(Collectors.toList());
		
	}
	
	public List<User> sortByDob() {
			Comparator<User> byDobComparator = Comparator.comparing(User::getDob);
			return  userRepo.findAll().stream().sorted(byDobComparator).collect(Collectors.toList());
		}

	public void softdeleteUsersById(int id,boolean value) {
		userRepo.softDelete(id,value);
	}

	public List<User> findByNameOrSurnameOrPincode(String name, String surname, String pincode) {
		return userRepo.findByNameOrSurnameOrPincode(name, surname, pincode);
	}

}
