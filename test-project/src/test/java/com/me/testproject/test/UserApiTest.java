package com.me.testproject.test;


import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.me.testproject.exceptions.ClientException;
import com.me.testproject.server.api.IUserApi;
import com.me.testproject.server.auth.Authorities;
import com.me.testproject.server.entities.Address;
import com.me.testproject.server.entities.User;

@ContextConfiguration({"classpath:WEB-INF/security-context.xml","classpath:WEB-INF/api-context.xml"})
public class UserApiTest extends AbstractTestCase {

	@Autowired
	private IUserApi userApi;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private User u;
	
	@Before
	public void setUp() {
		u = new User();
		u.setUserName("testuser");
		u.setPassword("xxxx");
		u.setDisabled(false);
		u.setDeleted(false);
		u.setAuthority(Authorities.ROLE_USER);
		
		Address address=new Address();
		address.setCity("Kathmandu");
		address.setCountry("Nepal");
		address.setCreated(new Date());
		address.setFirstLine("Dhapashi");
		address.setState("Bagmati");
		
		u.setAddress(address);
		
	}
	
	@Test
	public void createUserTest() {
		User persisted=userApi.createUser(u);
		long id=persisted.getId();
		Assert.assertEquals(1,id);
	}
	
	@Test
	public void getAllUsersTest() {
		userApi.createUser(u);
		
		u = new User();
		u.setUserName("testuser2");
		u.setPassword("xxxx");
		u.setDisabled(false);
		u.setDeleted(false);
		u.setAuthority(Authorities.ROLE_USER);
		
		Address address=new Address();
		address.setCity("London");
		address.setCountry("England");
		address.setCreated(new Date());
		address.setFirstLine("Test line");
		address.setState("London");
		
		u.setAddress(address);
		userApi.createUser(u);
		
		List<User> allUsers=userApi.getAllUsers();
		Assert.assertEquals(2, allUsers.size());
	}
	
	@Test
	public void updateUserTest() throws ClientException{
		u=userApi.createUser(u);
		Address address=new Address();
		address.setCity("KTM");
		address.setCountry("NEP");
		address.setCreated(new Date());
		address.setFirstLine("Test line");
		address.setState("BAG");
		
		u.setAddress(address);
		User persisted=userApi.updateUser(u);
		String city=persisted.getAddress().getCity();
		Assert.assertEquals("KTM",city);
	}
	
	@Test(expected=ClientException.class)
	public void changePasswordSuccessTest() throws ClientException{
		String old="xxxx";
		String newPass="newpass";
		u=userApi.createUser(u);
		u=userApi.changePassword(u.getId(), old, newPass);
		Assert.assertTrue(passwordEncoder.matches(newPass, u.getPassword()));
	}
	
	@Test(expected=ClientException.class)
	public void invalidOldPassTest() throws ClientException{
		u=userApi.createUser(u);
		String old="old";
		String newPass="newpass";
		
		u=userApi.changePassword(u.getId(), old, newPass);
	}
	@Test(expected=ClientException.class)
	public void invalidUserPassTest() throws ClientException{
		String old="old";
		String newPass="newpass";
		u=userApi.changePassword(1, old, newPass);
	}
}
