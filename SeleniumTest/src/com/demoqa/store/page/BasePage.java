package com.demoqa.store.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.store.util.ConfigFileReader;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor jse;
	public static String baseUrl = ConfigFileReader.getConfigValue("url");
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Integer.parseInt(ConfigFileReader.getConfigValue("wait")));
		this.jse = (JavascriptExecutor)driver;		
	}
	
	abstract public void goTo();
	abstract public boolean isAt();
	
	protected WebElement waitElement(String css){
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
		hl(ele);
		return ele;
	}
	
	protected void waitElementGone(String css){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
	}
	
	protected List<WebElement> waitElements(String css){
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(css)));
	}
	
	protected void hoverOnElement(WebElement ele){
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}
	
	protected WebElement elementFindElement(WebElement ele, String css){
		return ele.findElement(By.cssSelector(css));
	}
	
	protected void inputKey(String css, String key){
		waitElement(css).sendKeys(key);
	}
	
	protected void clickBtn(String css){
		waitElement(css).click();
	}
	
	protected void selectByText(String css, String text){
		WebElement ele = findElement(css);
		ele.click();
		pause(1);
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	protected WebElement findElement(String css){
		pause(1);
		return driver.findElement(By.cssSelector(css));
	}
	
	protected void pause(int i){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getText(String css){
		return waitElement(css).getText();
	}
	
	protected boolean isElementExist(String css){
		try{
			waitElement(css);
			return true;
		}catch(Exception e){}
		
		return false;
	}
	
	public void hl(WebElement ele)
    {            
        jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, " border: 3px solid red;");
        pause(1);
        jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, "");
    }

}
