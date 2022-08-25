import org.junit.Assert;
import org.junit.Test;
import pages.Cartpage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class CartTests extends BaseTest {
    @Test
    public void verificarCheckoutButtonWorks()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        cartpage.clickCheckoutButton();
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",cartpage.getInformationPageText());
    }

}
