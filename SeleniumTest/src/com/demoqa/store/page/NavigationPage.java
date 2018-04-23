package com.demoqa.store.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class NavigationPage extends BasePage{
	
	protected String product_category_css = "#menu-item-33";
	protected String products_list_css = "#menu-item-33 [id^='menu-item-']>a";
	
	private String item_count_css = "#header_cart .count";
	private String check_out_css = "[title='Checkout']";
    
	public NavigationPage(WebDriver driver){
		super(driver);
	}
	
	
	public void select_product(String product){
		WebElement elem = waitElement(product_category_css);	
		
		hoverOnElement(elem);		
		
		List<WebElement> elements = waitElements(products_list_css);
		
		for(WebElement ele: elements){
			String prod = ele.getText();
			if(prod.equals(product)){
				ele.click();
				break;
			}			
		}		
	}
	
	public CheckOut_YourCart_Page click_checkOut(){
		waitElement(check_out_css).click();
		
		return new CheckOut_YourCart_Page(driver);
	}
	
   protected int get_item_count(){
		
		return Integer.parseInt(waitElement(item_count_css).getText());
	}
	
   protected void wait_item_added_to_cart(int old_item_count){
		
		int waitSeconds = 10;
		int current_item_count = get_item_count();
		
		while(waitSeconds < 0 || current_item_count==old_item_count){
			current_item_count = get_item_count();
			pause(1);
			waitSeconds--;
		}
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
