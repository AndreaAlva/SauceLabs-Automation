package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    Homepage homepage = new Homepage(DriverManager.getDriver().driver);

    @Given("I set the user name field with {string}")
    public void setUserName(String userName){
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password field with {string}")
    public void setUserPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assert.assertTrue(homepage.appLogoIsDisplayed());
    }

    @Then("An error message that says {string} is displayed")
    public void verifyLoginErrorMessage(String message){
        Assert.assertEquals(message, loginPage.getLoginErrorMessage());
    }
}
