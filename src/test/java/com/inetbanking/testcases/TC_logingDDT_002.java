package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utlilites.XLUtils;


public class TC_logingDDT_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username,String password) throws InterruptedException 
	{
		Loginpage lp = new Loginpage(driver);
		lp.setUserName(username);
		Logger.info("username provided");
		lp.setPassword(password);
		Logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(1000);
  		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();  //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			lp.clickLogout();
	
			Thread.sleep(3000);
					
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	
	
		
		
	}
	public boolean isAlertPresent()   //user defined methos created to check alert is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		int rownum =XLUtils.getRowCount(path,"Sheet1");
		int colcount =XLUtils.getCellCount(path,"Sheet1",1);
	
		String logindata[][]= new String [rownum][colcount];
		
		for(int i =1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);  //excel 1,2 in array 0,1  so we use i-j
			}
		} 
		return logindata;
	}
		
}
