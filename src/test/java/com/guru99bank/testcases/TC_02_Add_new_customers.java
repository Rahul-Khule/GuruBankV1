package com.guru99bank.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageobjects.Add_new_customers_page_Objects;
import com.guru99bank.pageobjects.Login_page_Objects;



public class TC_02_Add_new_customers extends BaseClass {

	@Test
	public void addNewCustomerPage() throws InterruptedException, IOException {
		
		//login page constructor to login before created new customer
		Login_page_Objects lp =new Login_page_Objects(driver);
		lp.setUsername(uername);
		logger.info("Username entered");
		lp.setpassword(password);
		logger.info("passowrd entered");
		lp.clickonsubmit();
		logger.info("login submit clicked");
		
		//add new customer page constructor
		Add_new_customers_page_Objects newcust = new Add_new_customers_page_Objects(driver);
		newcust.clickNewcustomersection();
		logger.info("Clicked on new customer section");
		newcust.setcustomername("rahul D");
		logger.info("Customer name entered");
		newcust.ClickgenderRadioButton();
		logger.info("gender radio buttonn clicked");
		newcust.setdateOfBirth("23", "03", "1999");
		logger.info("DOB entered");
		newcust.setAddress("jod area");
		logger.info("Address entered");
		newcust.setcity("japan");
		logger.info("City entered");
		newcust.setstate("korea");
		logger.info("State entered");
		newcust.setpinno("432142");
		logger.info("PIN NO entered");
		//random phnum
		newcust.settelephoneno(generateRandomDigits(10));
		logger.info("TEL NO entered");
		//random email
		newcust.setemailid(generateRandomEmail());
		logger.info("Email entered");
		newcust.setpassword("rahul2323");
		logger.info("Customer password entered");
		Thread.sleep(6000);
		newcust.setsubmit();
		logger.info("customer account created submit clicked");
		 
		
		if (driver.findElement(By.linkText("Continue")).isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("-------------------test passed-----------------");
		}
		else {
			cpatureSS(driver, "TC_02_Add_new_customers");
			Assert.assertTrue(false);
			logger.info("--------------------test failed-------------------");
		}
		
	}
	
	

	
	
	
	
}
