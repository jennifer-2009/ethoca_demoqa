

package com.demoqa.store.page;

import org.openqa.selenium.WebDriver;

public class Page {
	
	public HomePage home(WebDriver driver){
		return new HomePage(driver);
	}
	
	public AccessoriesPage accessories(WebDriver driver){
		return new AccessoriesPage(driver);
	}
	
	public CheckOut_Info_Page CheckOut_Info(WebDriver driver){
		return new CheckOut_Info_Page(driver);
	}
	
	public CheckOut_Result_Page CheckOut_Result(WebDriver driver){
		return new CheckOut_Result_Page(driver);
	}
	
	public CheckOut_YourCart_Page CheckOut_YourCart(WebDriver driver){
		return new CheckOut_YourCart_Page(driver);
	}
	
	public NavigationPage Navigation(WebDriver driver){
		return new NavigationPage(driver);
	}

}
