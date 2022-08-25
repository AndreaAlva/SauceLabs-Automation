import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Cartpage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class HomeTests extends BaseTest {

    @Test
    public void verifyCartButtonNumberIsAdded(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
    }
    @Test
    public void verifyCartButtonNumberIsBlankWhereThereIsNotProductsInTheCart(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
        Assert.assertEquals( "", homepage.getCartIconText());
    }
    public void logear()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
    }
    @Test
    public void verificarLogOutButtonCierraSesion(){
        logear();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickMenuButton();
        homepage.clickLogoutButton();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        Assert.assertTrue(loginPage.appLogoIsDisplayed());
    }
    @Test
    public void verifyCartSymbolgoestoCartPage(){
        logear();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickMenuButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        Assert.assertEquals("YOUR CART",cartpage.getInformationPageText());
    }

}
