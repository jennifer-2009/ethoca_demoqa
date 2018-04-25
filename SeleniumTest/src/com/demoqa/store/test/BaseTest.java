package com.demoqa.store.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.demoqa.store.page.BasePage;
import com.demoqa.store.page.Page;


public class BaseTest {
	
	protected WebDriver driver;
	protected Page page;
	
	@BeforeClass
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		page = new Page();
		driver.get(BasePage.baseUrl);		
	}
	
	@AfterClass
	public void tearDown(){
		
		driver.quit();
	}
			

}
