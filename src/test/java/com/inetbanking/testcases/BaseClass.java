package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utlilites.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	
	public String baseURL =readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static  Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger = org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdegepath());
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshot/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}


}
