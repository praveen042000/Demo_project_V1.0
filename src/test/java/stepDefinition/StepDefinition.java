package stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.selenium.cucumber.SeleniumCucumberProject.LoginActions;
import com.selenium.cucumber.SeleniumCucumberProject.TimeActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.selenium.cucumber.SeleniumCucumberProject.AdminUserActions;
import com.selenium.cucumber.SeleniumCucumberProject.HelperClass;
import com.selenium.cucumber.SeleniumCucumberProject.Utility;

public class StepDefinition {
	LoginActions logact = new LoginActions();
	Utility data = new Utility();
	AdminUserActions ADac = new AdminUserActions();
	TimeActions TiAct = new TimeActions();

@Given("User is on the Website homepage")
public void user_is_on_the_orangehrm_com_homepage() {
	HelperClass.driver.get(data.url);
	HelperClass.log.info("Navigated to the website homepage");
}

@When("User enters the valid username and password")
public void user_enters_the_valid_username_and_password() {
	logact.loginAccount(data.username,data.password);	
	HelperClass.log.info("Entered valid username and password");
   
}

@When("User clicks the login button")
public void user_clicks_the_login_button() {
	logact.clickLoginButton();
	HelperClass.log.info("Clicked on the login button");
	
}

@Then("User sees the login successful message")
public void user_sees_the_login_successful_message() throws InterruptedException {
	Assert.assertTrue(logact.getVerifyText().contains("Dashboard"));
	HelperClass.log.info("Login successful. Dashboard page displayed");
    
}

@When("User enters the invalid username {string}")
public void user_enters_the_invalid_username(String string) {
	logact.username(string);
	HelperClass.log.info("Entered invalid username");
}

@When("User enters the invalid password {string}")
public void user_enters_the_invalid_password(String string) {
	logact.password(string);
	HelperClass.log.info("Entered invalid password");
}

@Then("Login is unsuccessful with error messages")
public void login_is_unsuccessful_with_error_messages() {
	Assert.assertTrue(logact.getErrorText().contains("Invalid credentials"));
	HelperClass.log.info("Login unsuccessful. Error message displayed");
}
@When("user selects the time feature")
public void user_selects_the_time_feature() {
	TiAct.clickTimeButton();
	HelperClass.log.info("user selects the time feature");
}

@When("user selects the projectinfo category")
public void user_selects_the_projectinfo_category() {
	TiAct.clickProjectInfo();
	 HelperClass.log.info("user selects the projectinfo category");
}

@When("user selects the customer option")
public void user_selects_the_customer_option() {
	TiAct.selectCustomer();
	HelperClass.log.info("user selects the customer option");
}

@When("user clicks the add button")
public void user_clicks_the_add_button() {
	TiAct.clickaddbutton();
	 HelperClass.log.info("user clicks the add button");
}

@When("user adds the addcustomer name, description, and clicks the save button")
public void user_adds_the_addcustomer_name_description_and_clicks_the_save_button() {
	TiAct.AddEmployee(data.name,data.discription);
    TiAct.savebutton();
    HelperClass.log.info("user adds the addcustomer name, description, and clicks the save button");
}

@Then("user sees the added customer details")
public void user_sees_the_added_customer_details() {
//	Assert.assertTrue(TiAct.getVerifydiscription().contains("welcome"));
//	  Assert.assertTrue(TiAct.getverifyerror().contains("Already exists"));
//	  HelperClass.log.info("user sees the added customer details");
}

}