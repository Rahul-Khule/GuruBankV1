package com.guru99bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_new_Account_Page_Objects {
	WebDriver l_driver;
	public Add_new_Account_Page_Objects(WebDriver r_driver)
	{
		l_driver = r_driver;
		PageFactory.initElements(r_driver, this);
	}
	
	//find elements
	@FindBy(name = "cusid")
	WebElement customerid;
	
	@FindBy(name = "selaccount")
	WebElement selectaccount;
	
	@FindBy(name = "inideposit")
	WebElement initalDeposit;
	
	@FindBy(name = "button2")
	WebElement submitbutton;
	
	@FindBy(linkText = "New Account")
	WebElement newAccount;
	
	//action class
	public void setCustomerID(String custID) {
		customerid.sendKeys(custID);
	 }
	public void selectAccountType() {
		Select select = new Select(selectaccount);
		select.selectByValue("Savings");;
	 }
	public void setinitalDeposit(String inDEPOST) {
		initalDeposit.sendKeys(inDEPOST);
	 }
	public void selectSubmit_Button_new_Account() {
		submitbutton.click();;
	 }
	public void click_On_New_Account_selection() {
		newAccount.click();;
	 }
	
}
