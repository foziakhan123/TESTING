package com.qa.DemoSite;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoReport {
	
	public ExtentReports report;
	public ExtentTest test;

		
	@Test
	public void login () {
		
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\BasicReport.html", true);
		
		test = report.startTest("Verify login");
		
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "Browser started");
		driver.get("http://thedemosite.co.uk");
		String title = driver.getTitle();
		
		
		if (title.equals("IT Training | Project Management Training | Business Skills Training | QA")) {
			test.log(LogStatus.PASS, "verify Title of the page");
		
	} else {
		test.log(LogStatus.FAIL, "verify Title of the page");
		
	
	}
		
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
