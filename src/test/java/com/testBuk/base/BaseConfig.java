package com.testBuk.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import uti.HtmlReport;

public class BaseConfig {
	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public String nameClass = "";
	public static HtmlReport htrep;

	@BeforeSuite
	public void setExtent() throws Exception {
		htrep = new HtmlReport();
		extent = htrep.getReport();
		System.out.println(System.getProperty("user.name"));

	}

	@BeforeMethod()
	public void getDriver(Method method) throws InterruptedException {
		String description = "";
		Test testName = method.getAnnotation(Test.class);
		description = (testName != null) ? testName.description() : "";
		extentTest = extent.startTest(nameClass, description);
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		driver = new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.demoblaze.com/");
		System.out.println("Successfully opened the website");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	}

	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException {
		System.out.println("State Case: " + nameClass + " = " + htrep.returnStateCase(result));
		htrep.generateStep(extentTest, result, "Caso ejecutado " + nameClass, driver);
		extent.endTest(extentTest);
		extent.flush();
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.close();
	}
}
