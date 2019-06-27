package com.qa.gmail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class GmailLoginClass extends TestBase {

	public GmailLoginClass()throws IOException {
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement Email;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement NextBtn;
	
	@FindBy(xpath="//button[contains(text(),'Forgot email?')]")
	WebElement forgotpwd;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement Password;
	
	
	public String validateloginpagetitle() {
		String s=dr.getTitle();
			return s;
		}
		
		public HomePage Login(String uname,String pword) throws IOException, InterruptedException {
		Email.sendKeys(uname);
		NextBtn.click();
		Thread.sleep(3000);
		Password.sendKeys(pword);
		NextBtn.click();
		Thread.sleep(3000);
		return new HomePage();
		}
	
}
