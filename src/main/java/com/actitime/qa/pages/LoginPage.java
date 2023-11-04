package com.actitime.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class LoginPage extends TestBase {
	
	   // Page Factory - OR
	   @FindBy(xpath = "//*[@id='username']")
	   WebElement userName;
   
	   @FindBy(xpath = "//*[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")
	   WebElement password;
   
	   @FindBy(xpath = "//div[@class='atLogoImg']")
	   WebElement actiTimeLogo;

	   @FindBy(xpath = "//*[@id=\"loginButton\"]/div")
	   WebElement loginBtn;
   
	   // Initializing the Page Objects
	   public LoginPage() {
		   PageFactory.initElements(driver, this);
	   }
   
	   // Actions
	   public String validateLoginPageTitle() {
		   return driver.getTitle();
	   }
	   public HomePage loging(String uName, String pword) {
		
		userName.sendKeys(uName);
		password.sendKeys(pword);
		loginBtn.click();
		return new HomePage();
		
	}
   
	   public boolean validateActiTimeLogo() {
		   return actiTimeLogo.isDisplayed();
	   }
   
	   public void enterUserName(String uName) {
			userName.sendKeys(uName);
	   }

	   public void enterPassword(String pwd) {
			password.sendKeys(pwd);
	   }

	   public HomePage clickSubmitButton() {
			loginBtn.click();
			return new HomePage();
	   }

}
