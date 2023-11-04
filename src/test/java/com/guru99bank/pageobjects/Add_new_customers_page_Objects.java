package com.guru99bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_new_customers_page_Objects {
	WebDriver ldriver;
	
	public Add_new_customers_page_Objects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//find elements
	@FindBy(linkText = "New Customer")
	WebElement newcustomersection;
	
	@FindBy(name = "name")
	WebElement customername;
	
	@FindBy(xpath = "//input[@value=\"m\"]")
	WebElement genderRadioButton;
	
	@FindBy(id = "dob")
	WebElement dateOfBirth;
	
	@FindBy(name = "addr")
	WebElement Address;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "pinno")
	WebElement pinno;
	
	@FindBy(name = "telephoneno")
	WebElement telephoneno;
	
	@FindBy(name = "emailid")
	WebElement emailid;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "sub")
	WebElement submit;
	
	//action method
	public void clickNewcustomersection() {
		newcustomersection.click();	 }
	
	 public void setcustomername(String cname) {
		 customername.sendKeys(cname);
	 }
	 
	 public void ClickgenderRadioButton() {
		 genderRadioButton.click();
	 }
	 
	 public void setdateOfBirth(String dd, String mm , String yyyy) {
		 dateOfBirth.sendKeys(dd);
		 dateOfBirth.sendKeys(mm);
		 dateOfBirth.sendKeys(yyyy);
	 }
	 
	 public void setAddress(String add) {
		 Address.sendKeys(add);
	 }
	 
	 public void setcity(String citys) {
		 city.sendKeys(citys);
	 }
	 
	 public void setstate(String states) {
		 state.sendKeys(states);
	 }
	 
	 public void setpinno(String pinnos) {
		 pinno.sendKeys(pinnos);
	 }
	 
	 public void settelephoneno(String telno) {
		 telephoneno.sendKeys(telno);
	 }
	 
	 public void setemailid(String email) {
		 emailid.sendKeys(email);
	 }
	 
	 public void setpassword(String pwd) {
		 password.sendKeys(pwd);
	 }
	 
	 public void setsubmit() {
		 submit.click();
	 }
	
	
	
	
	
	
	
	
}


