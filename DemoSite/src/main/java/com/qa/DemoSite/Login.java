package com.qa.DemoSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
		@FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
		private WebElement loginbutton;
		
		@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
		private WebElement enteruser;
		
		@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
		private WebElement enterpassword;
		
		@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
		private WebElement submitlogin;
		
		
		public void loginbutton () {
			loginbutton.click();
			
		}
		
		
		public void enteruser(String text) {
			enteruser.sendKeys(text);
		}
		
		public void enterpassword (String text){
			enterpassword.sendKeys(text);
		}
	
		
		public void submitlogin () {
			
			submitlogin.click();
		}
		

}
