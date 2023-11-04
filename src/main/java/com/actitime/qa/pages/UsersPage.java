package com.actitime.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase  {

    Logger log = Logger.getLogger(HomePage.class);
    
    @FindBy(xpath = "//*[@id='pageBody']/tbody/tr[1]/td[3]/div/div[2]/div[1]")
    WebElement newUserButton;
    
    @FindBy(xpath = "//*[@id='createUserPanel_firstNameField']")
    WebElement firstNameField;

    
    @FindBy(xpath = "//*[@id='createUserPanel_lastNameField']")
    WebElement lastNameField;
    
    @FindBy(xpath = "//*[@id='createUserPanel_emailField']")
    WebElement emailField;
    
    @FindBy(xpath = "//*[@id='createUserPanel']/div[3]/div/div[3]/div[1]/div[1]")
    WebElement createUserButton;

    @FindBy(xpath = "//*[@id='createUserPanel']/div[2]/div[1]")
    WebElement successElement;

    // Constructor to initialize page elements
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterUserDetails(String firstName, String lastName, String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout

        // Wait for the first name field to be clickable and then send keys
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).clear();
        firstNameField.sendKeys(firstName);

        // Wait for the last name field to be clickable and then send keys
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).clear();
        lastNameField.sendKeys(lastName);

        // Wait for the email field to be clickable and then send keys
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void clickOnAddNewUser() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement createUserButton = wait.until(ExpectedConditions.visibilityOf(newUserButton));
        if(createUserButton.isEnabled() && createUserButton.isDisplayed()) {
            createUserButton.click();
        } else {
            log.warn("Users Link is not clickable");
        }
    }
    
    public void clickOnCreateUser() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement newUser = wait.until(ExpectedConditions.visibilityOf(createUserButton));
        if(newUser.isEnabled() && newUser.isDisplayed()) {
            newUser.click();
        } else {
            log.warn("Users Link is not clickable");
        }
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            // Wait for the success message element to be visible
            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(successElement));
            // Return true if the element is visible
            return successMessageElement.isDisplayed();
        } catch (TimeoutException e) {
            // Return false if the element is not visible within the timeout
            return false;
        }
    }

}
