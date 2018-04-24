package com.demoqa.store.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.demoqa.store.page.Page;
import com.demoqa.store.util.ConfigFileReader;

public class BaseTest {
	
	protected WebDriver driver;
	protected Page page;
	
	@BeforeClass
	public void setUp(){
		long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		page = new Page();
		driver.get(ConfigFileReader.getConfigValue("url"));		
	}
	
	@AfterClass
	public void tearDown(){
		long id = Thread.currentThread().getId();
        System.out.println("after test-method. Thread id is: " + id);
		driver.quit();
	}
			

}
