package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
public	static WebDriver dr;
public	static Properties prop;

	
	public TestBase() throws IOException {
		
		prop=new Properties();
		
		FileInputStream f;
	
			f = new FileInputStream("C:\\Users\\ishit\\eclipse-workspace\\GmailTest\\src\\main\\java\\com\\qa\\gmailconfig\\gmailconfig.properties");

		prop.load(f);
		
	}
	public static void initializebrowser() throws IOException {
	String brname=	prop.getProperty("browser");
	
	if(brname.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishit\\Downloads\\chromedriver_win32\\chromedriver.exe");
		dr=new ChromeDriver();
		
	}else if(brname.equals("Chrome")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ishit\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		dr=new FirefoxDriver(); 
	}

	dr.manage().window().maximize();
	dr.manage().deleteAllCookies();
	dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	dr.get(prop.getProperty("url"));
	
	
	
	
	}
}
