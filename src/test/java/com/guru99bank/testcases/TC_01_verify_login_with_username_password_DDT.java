package com.guru99bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageobjects.Login_page_Objects;
import com.guru99bank.utilities.XLUtils;

//8 DDT
public class TC_01_verify_login_with_username_password_DDT extends BaseClass{
	
	@Test(dataProvider = "Logindata")
	public void LoginDDT(String user, String pwd) throws IOException 
	{
		Login_page_Objects lp = new Login_page_Objects(driver);
		lp.setUsername(user);
		lp.setpassword(pwd);
		lp.clickonsubmit();
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();//closes the alert
			driver.switchTo().defaultContent();//focus on main page after closing alert
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clickonlogout();
			driver.switchTo().alert().accept();//closes the logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	
	//8. create user defined method because when given invalid user name or pass alret in popped up so need
	// close it in order to continue the test
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
			}
		catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	//8 data provider to take data from excel and store it in 2 dim array and return it
	@DataProvider(name = "Logindata")
	String[][] getdata_from_excel() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/guru99bank/testdata/login_page_Excel_File.xlsx";
		//8. count num row and cloumn 
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1", 1);
		
		//8. create 2d array to read
		String loginData[][]= new String[rownum][colcount];
		
		//8. outter for represents rows
		for(int i = 1;i<=rownum;i++) {
			//8.inner for loop represents columns
			for(int j = 0;j<colcount;j++) {
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
			
		}
		return loginData;
		}
}
