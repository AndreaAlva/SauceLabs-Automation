package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class CartNumberSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    Homepage homepage = new Homepage(DriverManager.getDriver().driver);

    @Given("I login into sauce labs page")
    public void setAllcredentials()
    {
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homepage.appLogoIsDisplayed());
    }
    @And("I click Add to cart button of any product")
    public void clickAddtocartButton()
    {
        homepage.clickOnAddSauceLabsBackPackToCartButton();
    }
    @Then("Cart number is displayed and incremented")
    public void cartNumberisIncremented()
    {
        Assert.assertEquals("1",homepage.getNumberCart());
    }




}
