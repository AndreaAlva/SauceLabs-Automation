package StepDefinitions;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;

public class LowtoHighSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    Homepage homepage = new Homepage(DriverManager.getDriver().driver);
    @Given("I login into sauce lab page")
    public void setAllcredentials()
    {
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homepage.appLogoIsDisplayed());
    }
    @And("I choose low to high option from the combo box")
    public void selectLowtoHighOption()
    {
        homepage.selectProductFilter("Price (high to low)");

    }
    @Then("All products get sort in low to high order")
    public void productsAreSorted()
    {
        List<Double> prices = homepage.getPricesList();
        boolean isSorted = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(isSorted);
    }

}
