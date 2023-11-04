package com.guru99bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page_Objects {

		WebDriver l_driver;
		
		public Login_page_Objects(WebDriver r_driver) {
			l_driver = r_driver;
			PageFactory.initElements(r_driver, this);
		}
		 
		 //find elements
		 @FindBy(name = "uid")
		 WebElement txtUsername;
		 
		 @FindBy(name = "password")
		 WebElement txtpassword;
		 
		 @FindBy(name = "btnLogin")
		 WebElement buttonSubmit;
		 
		 @FindBy(linkText = "Log out")
		 WebElement logout;
		 
		 //action methods
		 public void setUsername(String uname) {
			 txtUsername.sendKeys(uname);
		 }
		 public void setpassword(String pwd) {
			 txtpassword.sendKeys(pwd);
		 }
		 public void clickonsubmit() {
			 buttonSubmit.click();
		 }
		 public void clickonlogout() {
			 logout.click();
		 }
}
