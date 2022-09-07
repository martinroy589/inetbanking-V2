package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtuserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement InkLogout;
	
	public void setUserName(String username)
	{
		txtuserName.sendKeys(username);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void clickSubmit()
	{
		btnlogin.click();
	}
	
	public void clickLogout() {
		// TODO Auto-generated method stub
		InkLogout.click();
	}
}
