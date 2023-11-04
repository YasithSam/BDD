package com.actitime.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends TestBase {
	
	Logger log = Logger.getLogger(HomePage.class);
	
	
	//Page Factory - Object Repository
	
	@FindBy(xpath = "//*[@id='topnav']/tbody/tr/td[6]/a")
    WebElement usersLink;

	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement taskLink;
	
	@FindBy(xpath = "//a[@class='content reports']")
	WebElement reportsLink;
	
	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement actitimeLogo;


    // Initialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

	public Boolean validateActiTimeLogo() {	
		log.info("Validated Logo");
		return actitimeLogo.isDisplayed();
		
	}
	public TasksPage clickOnTaskLink() {		
		taskLink.click();
		return new TasksPage();
		
	}
	
	public ReportsPage clickOnReportsLink() {
		log.info("Validated Logo");
		reportsLink.click();
		return new ReportsPage();
		
	}

	public UsersPage clickOnUsersTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement usersLinkVisible = wait.until(ExpectedConditions.visibilityOf(usersLink));
		if(usersLinkVisible.isEnabled() && usersLinkVisible.isDisplayed()) {
			usersLink.click();
		} else {
			log.warn("Users Link is not clickable");
		}
		return new UsersPage();

    }
	
    
	
}
