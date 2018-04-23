package com.demoqa.store.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut_Result_Page extends NavigationPage{
	
	private String page_name_css = "h1.entry-title";
	private String result_table_css = "tbody>tr>td";
	
	public CheckOut_Result_Page(WebDriver driver){
		super(driver);
	}
	
	public String[] getResultArray(){
		List<String> resultList = new ArrayList<String>();
		
		List<WebElement> list = waitElements(result_table_css);
		
		for(WebElement ele : list){
			resultList.add(ele.getText());
		}
		
		String[] resultArray = new String[resultList.size()];
		return resultList.toArray(resultArray);
	}
	
	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAt() {
		return (getText(page_name_css).equalsIgnoreCase("Transaction Results"));
	}


}
