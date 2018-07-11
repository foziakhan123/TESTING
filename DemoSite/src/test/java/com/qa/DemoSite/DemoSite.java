package com.qa.DemoSite;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoSite {
	
	WebElement element;
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	String LoginData = "C://Users//Admin//Desktop//SeleniumExamples//LoginData.xlsx";
	
	
	@Before
	public void setup () {
		System.setProperty("webdriver.chrome.driver",
				"C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver ();
		report = new ExtentReports("C://Users//Admin//Desktop//AutomationReports//BasicReport.html", true);
		test = report.startTest("StartingTest");
		
	}
	
	@After
	public void teardown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	@Test
	public void excelTest() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(LoginData);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);
			
			String newuser = username.getStringCellValue();
			String pass = password.getStringCellValue();
			
			driver.get("http://thedemosite.co.uk");
			driver.manage().window().maximize();
			
			test.log(LogStatus.INFO, "navigate to homepage");
			test.log(LogStatus.INFO, "inputting new username");
			
			Home home = PageFactory.initElements(driver, Home.class);
			home.button();
			
			User user = PageFactory.initElements(driver, User.class);
			user.username("hello");
			user.password("password");
			user.save();
			
			
			Login loginuser = PageFactory.initElements(driver, Login.class);
			loginuser.loginbutton();
			
			
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	@Test
	public void loginTest () {
		
		
		test = report.startTest("Register User");
		test.log(LogStatus.INFO, "Add user");
		test.log(LogStatus.PASS, "Passed");
		
		report.endTest(test);
		report.flush();
		driver.quit();
		
		
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk");
		Home home = PageFactory.initElements(driver, Home.class);
		home.button();
		
		User user = PageFactory.initElements(driver, User.class);
		user.username("hello");
		user.password("password");
		user.save();
		
		Login loginuser = PageFactory.initElements(driver, Login.class);
		loginuser.loginbutton();
		loginuser.enteruser("hello");
		loginuser.enterpassword("password");
		loginuser.submitlogin();
		
		
	}
	
	
	
	
	@Test
	
	public void mthodTest() {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk");
		
		WebElement button = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		button.click();
		
		WebElement username = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		username.sendKeys("hello");
		
		WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		password.sendKeys("password");
		
		WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		save.submit();
		
		WebElement login = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();
		
		WebElement fillusername = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		fillusername.sendKeys("hello");
		
		WebElement fillpassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		fillpassword.sendKeys("password");
		
		WebElement loginuser = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		loginuser.submit();
		
		assertEquals ("**Successful Login**", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
		
		
		
		
		
		
		
	}

}
