package com.actitime.qa.stepdefinitions;

import static com.actitime.qa.base.TestBase.initialization;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;


public class CreateUser {
    private LoginPage loginPage;
    private HomePage homePage = new HomePage();
    private UsersPage usersPage = new UsersPage();

    @Given("^the admin is logged in to the HR management system with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_admin_is_logged_in_to_the_HR_management_system_with_and(String username, String password) {
        initialization();
        loginPage = new LoginPage();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        homePage = loginPage.clickSubmitButton();
    }

    @When("^the admin navigates to the Users page$")
    public void the_admin_navigates_to_the_Users_page() {
        // Add code here that turns the phrase above into concrete actions
        usersPage = homePage.clickOnUsersTab();
    }

    @And("^the admin clicks the button to create a new user$")
    public void the_admin_navigates_to_Create_User_page() {
        // Add code here that turns the phrase above into concrete actions
        usersPage.clickOnAddNewUser();
    }

    @And("^the admin fills in the mandatory fields for a new user with \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void the_admin_fills_in_the_mandatory_fields_for_a_new_user_with_and(String firstName, String lastName, String email) {

        usersPage.enterUserDetails(firstName, lastName, email);
    }

    @And("^the admin submits the new user creation form$")
    public void the_admin_submits_the_new_user_creation_form() {
        // Add code here that turns the phrase above into concrete actions
        usersPage.clickOnCreateUser();
    }

    @Then("^a new user account should be created successfully$")
    public void a_new_user_account_should_be_created_successfully() {
        assertTrue("The success message should be visible", usersPage.isSuccessMessageDisplayed());
    }
    
}
