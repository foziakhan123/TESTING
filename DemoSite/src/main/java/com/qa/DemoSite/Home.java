package com.qa.DemoSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Home {
	
		@FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
		private WebElement button;
		
		public void button () {
			
			button.click();
		}
		
		
		

}
