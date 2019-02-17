package com.ecomm.test;

import junit.framework.TestCase;


import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;



public class UserDAOUnitTest {
	static UserDAO userDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
//	@Ignore
	@Test
	public  void registerUser() 
	{
		UserDetail user=new UserDetail();
		
		user.setMobileNo("9840705882");
		user.setPassword("sumathi123");
		user.setUserName("sumathi");
		user.setAddr("perambur");
		user.setRole("user");
		user.setEnabled(true);
		user.setCustomerName("sumathi ramamoorthy ");
		
		assertTrue("Problem in User Insertion",userDAO.registerUser(user));
	
	}
	
	@Ignore
	@Test
	public  void deleteUser() 
	{
		UserDetail user=userDAO.getUserId(50);
		assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public  void updateUser() 
	{

		UserDetail user=userDAO.getUserId(50);
	    user.setAddr("Anna Nagar");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	
	@Test
	public void listUserTest()
	{
		List<UserDetail> listUserDetails=userDAO.listUserDetails();
		assertNotNull("No Categories",listUserDetails);
		
		for(UserDetail user: listUserDetails)
		{
			System.out.print(user.getUserId()+":::");
			System.out.print(user.getUserName()+":::");
			System.out.println(user.getMobileNo());
		}
	}
	
	

}