package com.demoqa.store.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut_YourCart_Page extends NavigationPage{
	
	private String item_rows = "[class^='product_row product_row_']";
	private String item_quantity_css = "[type='text'][name='quantity']";
	private String item_name_css = "a[href^='http']";
	private String checkOut_continue_css = "[style^='display'] [href='#']";
	
	public CheckOut_YourCart_Page(WebDriver driver){
		super(driver);
	}
	
	public int get_item_quantity(String prod){
		List<WebElement> list = waitElements(item_rows);
		
		for(WebElement ele : list){
			String text = elementFindElement(ele, item_name_css).getText();
			if(text.equalsIgnoreCase(prod)){
				 String quantityText = elementFindElement(ele, item_quantity_css).getAttribute("value");
				 return Integer.parseInt(quantityText);
			}
		}
		return 0;
	}
	
	public int get_item_quantity(){
		String quanTitiy_text = waitElement(item_quantity_css).getAttribute("value");
		return Integer.parseInt(quanTitiy_text);
	}
	
	public void click_checkout_continue(){
		waitElement(checkOut_continue_css).click();
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
