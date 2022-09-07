package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass {
	
		@Test
		public void loginTest() throws IOException
		{

			
			Logger.info("URL is openend");
			
			Loginpage lp = new Loginpage(driver);
			
			lp.setUserName(username);
			Logger.info("Entered Username");
			
			lp.setPassword(password);
			Logger.info("Entered Password");
			lp.clickSubmit();
//			try {
			if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
			{
				
				Assert.assertTrue(true);
				Logger.info("login test passed");
			}
			else
			{
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
				Logger.info("login test failed");
			}
//			}
//			 catch (AssertionError e) {
//		         System.out.println(e.getMessage());
//		      }
		}

}
