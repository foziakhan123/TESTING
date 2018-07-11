package com.qa.ShoppingWebsite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



public class ShoppingWebsite {
	
	WebElement element;
	WebDriver driver;
	
	@Before
	public void setup () {
		System.setProperty("webdriver.chrome.driver",
				"C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver ();
	}
	
	@After
	public void teardown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		Home home = PageFactory.initElements(driver, Home.class);
		home.product("dress");
		
		DressPage choosedress = PageFactory.initElements(driver, DressPage.class);
		choosedress.choosedress();
		
		
	}
	
	

	
	@Test
	@Ignore
	public void mthodTest() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		search.click();
		search.sendKeys("dress");
		search.submit();
		
		WebElement printeddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
		printeddress.click();
		
		
		assertEquals ("Printed Dress", driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a")).getText());
		
	}

}
