package com.demoqa.store.page;

import org.openqa.selenium.WebDriver;

public class AccessoriesPage extends NavigationPage{
	
	private String magic_mouse_buy_css = "[action$='magic-mouse/'] [name='Buy']";
	private String apple_tv_buy_css = "[action$='apple-tv/'] [name='Buy']";
	
	
			
	public AccessoriesPage(WebDriver driver){
		super(driver);
	}
	
	public enum products{Magic_Mouse, Apple_TV }
	public AccessoriesPage add_product_to_cart(products prod){
		int old_item_count = get_item_count();
		
		switch(prod){
		case Magic_Mouse:
			waitElement(magic_mouse_buy_css).click();
			break;
		case Apple_TV:
			waitElement(apple_tv_buy_css).click();
			break;
		}
		
		wait_item_added_to_cart(old_item_count);
		
		return this;
	}
	
	
	
	
	
	
	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return false;
	}

}
