package com.guru99bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageobjects.Login_page_Objects;

public class TC_01_Verify_login_with_vaild_username_password extends BaseClass {

	@Test
	public void logintest() throws IOException 
	{
		//create an object of page object to call methods 
		Login_page_Objects lp =new Login_page_Objects(driver);
		//got the username for base class
		lp.setUsername(uername);
		logger.info("Username entered");
		//got the password for base class
		lp.setpassword(password);
		logger.info("password entered");
		//got the method from  base class
		lp.clickonsubmit();
		logger.info("Clicked on Login submit");
		
		String titlepg = driver.getTitle();
		if (titlepg.equals("titlepg")) {
			Assert.assertTrue(true);
			logger.info("---------------test passed------------------");
			
		}else {
			cpatureSS(driver, "TC_01_Verify_login_with_vaild_username_password");
			Assert.assertTrue(false);
			logger.info("-------------------test failed------------------");
		}
	}
	
	
}
