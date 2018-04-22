package com.demoqa.store.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TransactionTest {
	
	@Test
	public void test01(){
		System.setProperty("webdriver.chrome.driver", "C:\\QA\\workspace_ethoca\\SeleniumTest\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
	}

}
