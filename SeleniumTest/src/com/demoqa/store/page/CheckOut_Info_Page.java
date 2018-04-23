package com.demoqa.store.page;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class CheckOut_Info_Page extends NavigationPage{
	
	private String input_firstName_css = "[title='billingfirstname']";
	private String input_lastName_css = "[title='billinglastname']";
	private String input_address_css = "[title='billingaddress']";
	private String input_city_css = "[title='billingcity']";
	private String input_state_css = "[title='billingstate']";
	private String input_email_css = "[title='billingemail']";
	private String select_country_css = "select[title='billingcountry']";
	private String input_postCode_css = "[title='billingpostcode']";
	private String input_phone_css = "[title='billingphone']";
	private String input_shippingRegion_css = "td>.shipping_region.text";
	
	private String btn_puchase = ".make_purchase";
	
	
	public CheckOut_Info_Page(WebDriver driver){
		super(driver);
	}	
	
	public void edit_checkout_form(JSONObject jobject) {
    	for(int i = 0; i<jobject.names().length(); i++){
    		String input_value = null;
			try {
				input_value = (String)jobject.get(jobject.names().getString(i));
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		try {
				switch (jobject.names().getString(i)) {
				case "input_email":
					this.input_email(input_value);
					break;
				case "input_firstName":
					input_firstName(input_value);
					break;
				case "input_lastName":
					this.input_lastName(input_value);
					break;
				case "input_address":
					this.input_address(input_value);
					break;
				case "input_city":
					this.input_city(input_value);
					break;
				case "input_state":
					this.input_state(input_value);
					break;
				case "select_country":
					this.select_country(input_value);
					break;
				case "input_postCode":
					this.input_postCode(input_value);
					break;
				case "input_phone":
					this.input_phone(input_value);
					break;
				case "input_shippingRegion":
					this.input_shippingRegion(input_value);
					break;
				
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	this.click_puchage();
    }
	
	private void input_email(String email){
		inputKey(input_email_css, email);
	}
	
	private void click_puchage(){
		clickBtn(btn_puchase);
	}
	
	private void input_shippingRegion(String shipRegion){
		inputKey(input_shippingRegion_css, shipRegion);
	}
	
	private void input_phone(String phone){
		inputKey(input_phone_css, phone);
	}
	
	private void input_postCode(String postcode){
		inputKey(input_postCode_css, postcode);
	}
	
	private void input_firstName(String fName){
		inputKey(input_firstName_css, fName);
	}
	
	private void input_lastName(String LName){
		inputKey(input_lastName_css, LName);
	}
	
	private void input_address(String addr){
		inputKey(input_address_css, addr);
	}
	
	private void input_city(String city){
		inputKey(input_city_css, city);
	}
	
	private void input_state(String state){
		inputKey(input_state_css, state);
	}
	
	private void select_country(String country){
		
		selectByText(select_country_css, country);
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
