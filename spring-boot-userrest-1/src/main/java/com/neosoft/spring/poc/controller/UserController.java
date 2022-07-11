package com.neosoft.spring.poc.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.spring.poc.model.User;
import com.neosoft.spring.poc.repository.UserRepository;
import com.neosoft.spring.poc.service.InvalidRequestException;

@RestController
public class UserController {

	

	@Autowired
	com.neosoft.spring.poc.service.UserService userService;
	
	UserRepository userRepository;
	
	@PostMapping("/add/users/{phoneno}")
	public User addUsers(@RequestBody User user, @PathVariable long phoneno){
		if(userService.getUsersByPhoneno(phoneno).isPresent()) {
			throw new InvalidRequestException("User with this Phone number " + 
    			phoneno + " is already exist.");
}
			
		 return userService.addUsers(user);
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/softusers")
	public List<User> getSoftUsers(){
		return userService.getSoftUsers();
	}
	
	@GetMapping("/usersbyname/{name}")
	public List<User> getUsersByName(@PathVariable String name){
		return userService.getUsersByName(name);
	}
	
	@GetMapping("/usersbyid/{id}")
	public Optional<User> getUsersById(@PathVariable int id){
		return userService.getUsersById(id);
	}
	
	
	@GetMapping("/usersbysurname/{surname}")
	public List<User> getUsersBySurName(@PathVariable String surname){
		return userService.getUsersBySurName(surname);
	}
	
	@GetMapping("/usersbypincode/{pincode}")
	public List<User> getUsersByPincode(@PathVariable String pincode){
		return userService.getUsersByPincode(pincode);
	}
	
	
	@GetMapping("/User/search/all/{name}/{surname}/{pincode}")
	public List<User> searchAll(@PathVariable String name,@PathVariable String surname,@PathVariable String pincode){
		return userService.findByNameOrSurnameOrPincode(name, surname,pincode);
	}
	
	@GetMapping("/sort/sortbyDob")
	public List<User> sortByDob( User user) {
		return userService.sortByDob();
	}
	
	@GetMapping("/sort/sortbyDoj")
	public List<User> sort( User user) {
		return userService.sortByDoj();
	}
	
	
	
	
	@DeleteMapping("/delete/users/{id}")
	public List<User>  delete(@PathVariable  int id) {
		 if (!userService.getUsersById(id).isPresent()) {
	            throw new InvalidRequestException("User with ID " + 
	            			id + " does not exist.");
	        }
	        userService.deleteUsersById(id);
	        return getAllUsers();
	}
	
	@DeleteMapping("/delete/softusers/{id}")
	public void  softDelete(@PathVariable  int id) {
		 if (!userService.getUsersById(id).isPresent()) {
	            throw new InvalidRequestException("User with ID " + 
	            			id + " does not exist.");
	        }
		 boolean value= true;
	        userService.softdeleteUsersById(id,value);
	}
	
	@PutMapping("/update/users/{id}")
	public User updateInfo(@RequestBody User user , @PathVariable int id ) {
		if(userService.getUsersById(id).isPresent() ) {
			user.setId(id);
			return userService.update(user);
		}
		else {
			throw new InvalidRequestException("User with ID " + 
        			user.getId() + " does not exist.");
		}	
	}
	
}
