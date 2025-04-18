package stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

//import org.junit.Assert;
import org.testng.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.selenium.cucumber.SeleniumCucumberProject.LoginActions;
import com.selenium.cucumber.SeleniumCucumberProject.OrganisationtActions;
import com.selenium.cucumber.SeleniumCucumberProject.SkillActions;
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
	OrganisationtActions OrgAc = new OrganisationtActions();
	SkillActions skillac = new SkillActions();

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

@When("User clicks admin feature")
public void user_clicks_admin_feature() {
	OrgAc.getAdmin();
	 HelperClass.log.info("User clicks admin feature");
}

@When("user selects Organization category")
public void user_selects_organization_category() {
	OrgAc.getOrganization();
	 HelperClass.log.info("user selects Organization category");
}

@When("User selects Structure in organaization category")
public void user_selects_structure_in_organaization_category() {
	OrgAc.getStructure();
	HelperClass.log.info("User selects Structure in organaization category");
}

@When("User enables Edit function")
public void user_enables_edit_function() {
	OrgAc.getEdit();
    HelperClass.log.info("User enables Edit function");
}

@When("User clicks Add button")
public void user_clicks_add_button() {
	 OrgAc.getAdd();
	   HelperClass.log.info("User clicks Add button");
}

@When("User enters unit identification using sheetname {string} and rownumber {int}")
public void user_enters_unit_identification_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
	OrgAc.excelsheetread(sheetname,rownumber);
    HelperClass.log.info("User enters unit identification");
}

@When("user clicks save")
public void user_clicks_save() {
	OrgAc.getSave();
	HelperClass.log.info("user clicks save");
}

@Then("User should be able to see structure added sucessfully")
public void user_should_be_able_to_see_structure_added_sucessfully() {
	Assert.assertEquals(OrgAc.getAssertStructureExit(),"Organization Structure");
	HelperClass.log.info("User should be able to see structure added sucessfully");
}

@When("User selects Job")
public void user_selects_job() {
	ADac.getJob();
	HelperClass.log.info("User selects Job");
}

@When("User selects Employee Status")
public void user_selects_employee_status() {
	 ADac.getEmployeestatus();
	   HelperClass.log.info("User selects Employee Status");
}

@When("User Clicks on Add button")
public void user_clicks_on_add_button() {
	ADac.getAddButton();
	   HelperClass.log.info("User Clicks on Add button");
}

@When("User Enters the Employee Status")
public void user_enters_the_employee_status() {
	 ADac.setUserStatus();
	    HelperClass.log.info("User Enters the Employee Status");
}

@When("User Clicks on Save button")
public void user_clicks_on_save_button() {
	 ADac.getSaveButton();
	   HelperClass.log.info("User Clicks on Save button");
}

@Then("User Recevices Successfully Saved message")
public void user_recevices_successfully_saved_message() {
	 HelperClass.log.info("User Recevices Successfully Saved message");
}

@When("user select the qualification category")
public void user_select_the_qualification_category() {
	skillac.clickqualificationButton();
	HelperClass.log.info("user select the qualification category");
}

@When("user select the add skills category")
public void user_select_the_add_skills_category() {
	skillac.clickskillButton();
	skillac.clickskilladdButton();
	HelperClass.log.info("user select the add skills category");
}

@When("user enter the details using sheetname {string} and rownumber {int}")
public void user_enter_the_details_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
	skillac.excelsheetread(sheetname,rownumber);
	HelperClass.log.info("user enter the details");
}

@When("user click save button")
public void user_click_save_button() {
	skillac.clickskillsaveButton();
    HelperClass.log.info("user click save button");
}

@Then("user is able to see the added skilled details")
public void user_is_able_to_see_the_added_skilled_details() {
	skillac.getVerifyTextskill();
	HelperClass.log.info("user is able to see the added skilled details");
}



}