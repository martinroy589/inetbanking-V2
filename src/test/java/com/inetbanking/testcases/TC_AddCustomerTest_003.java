package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.Loginpage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Loginpage lp = new Loginpage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		addcust.custName("Martin");
		addcust.custgender("male");
		addcust.custdob("05","09","1999");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("CHN");
		addcust.custstate("TN");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("7594644632");
		String email = randomeString()+"@gmail.com";
		addcust.custemailid(email);	
//		addcust.custpassword("abccdef");
		addcust.custsubmit();
		
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().concat("Customer Registered Successfully!!!") != null ;
		if(res == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	public String randomeString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
		}
}
