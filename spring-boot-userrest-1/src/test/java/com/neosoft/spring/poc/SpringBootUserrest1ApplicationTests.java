package com.neosoft.spring.poc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import com.neosoft.spring.poc.model.User;
import com.neosoft.spring.poc.repository.UserRepository;



@SpringBootTest
class SpringBootUserrest1ApplicationTests {
	
	@Autowired
	UserRepository userRepo;

		
	
	@Test
    public void getAllUsers () {
    	List list = userRepo.findAll();
    	assertThat(list).size().isGreaterThan(0);
    }
	
	  @Test
	    public void getUser () {
	    	User user = userRepo.findById(3).isPresent() ? userRepo.findById(3).get():null;
	    	assertEquals("ms", user.getName());
	    }
	
	
	  @Test
		public void updateUser () {
			User u = userRepo.findById(3).get();
			u.setEmail("mahendra@gmail.com");
			
			userRepo.save(u);
		
			assertNotEquals("mahendra@gmail.com", userRepo.findById(3).get().getEmail());
		}
		
	
		@Test
		public void deleteUser () {
			userRepo.deleteById(6);
			assertThat(userRepo.existsById(6)).isFalse();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


private void assertNotNull(Object User) {
		// TODO Auto-generated method stub
		
	}



private void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

  private void assertNotNull(User user) {
		// TODO Auto-generated method stub
		
	}
    

	private void assertNotEquals(String string, String email) {
		// TODO Auto-generated method stub
		
	}
 


}
