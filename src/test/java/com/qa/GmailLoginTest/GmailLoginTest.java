package com.qa.GmailLoginTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.gmail.GmailLoginClass;
import com.qa.gmail.HomePage;

public class GmailLoginTest extends TestBase {
	GmailLoginClass loginPage;
	HomePage homePage;
	public GmailLoginTest() throws IOException{
		super();
	}
	@BeforeMethod
		public void setup() throws IOException {
			initializebrowser();
			loginPage=new GmailLoginClass();	
		
	}
	

	/*@Test(priority=2)
	public void loginPageTitleTest(){
		String title = loginPage.validateloginpagetitle();
		Assert.assertEquals(title, "Gmail");
	}*/
		
	@Test(priority=1)
	public void Login() throws IOException, InterruptedException {

			HomePage homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@AfterMethod
	public void teardown() {
		dr.quit();
	}
}
