package com.guru99bank.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageobjects.Add_new_Account_Page_Objects;
import com.guru99bank.pageobjects.Login_page_Objects;

public class TC_03_Add_New_Account extends BaseClass{
	
	@Test
	public void test_add_new_account() throws IOException {
		//create object of login page object to login 
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
		
		
		
		//create an object of page object to call methods
		Add_new_Account_Page_Objects accPG = new Add_new_Account_Page_Objects(driver);
		accPG.click_On_New_Account_selection();
		logger.info("Clicked on NEW ACCOUNT SECTION");
		accPG.setCustomerID(CustomerID);
		logger.info("Customer user id entered:" + CustomerID);
		accPG.selectAccountType();
		logger.info("savings account type selected");
		accPG.setinitalDeposit("1000");
		logger.info("Intital Deposit Done");
		accPG.selectSubmit_Button_new_Account();
		logger.info("Clicked on submit");
		
		//get the account number
		String AccountNO = driver.findElement(By.xpath("//td[text()='Account ID']/..//td[2]")).getText();
		System.out.println("AccountNO " +  AccountNO);
		logger.info("got the account num");
		
		
		//find the amount deposit from table
		String currentBal = driver.findElement(By.xpath("//td[text()='Current Amount']/..//td[2]")).getText();
		if (currentBal.equals("1000")) {
			Assert.assertTrue(true);
			logger.info("-----------------------test passed --------------------------");
		}
		else {
			cpatureSS(driver, "TC_03_Add_New_Account");
			Assert.assertTrue(false);
			logger.info("---------------------------test failed------------------------");
		}
		
		
	}
}
