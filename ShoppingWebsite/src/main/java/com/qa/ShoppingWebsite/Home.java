package com.qa.ShoppingWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	
	@FindBy (xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchBox;
	
	@FindBy (xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement search;
	
	public void product (String text) {
		searchBox.sendKeys(text);
		search.click();
	}
		
		
		
		
	
	
	
	

}
