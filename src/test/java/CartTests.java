import org.junit.Assert;
import org.junit.Test;
import pages.Cartpage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class CartTests extends BaseTest {
    @Test
    public void verificarCheckoutButtonTest()
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
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",cartpage.getTitlePageText());
    }
    @Test
    public void verifyQuantityProductAddedTest() //Test 2
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        cartpage.setQuantity(5);
        Assert.assertTrue(cartpage.getProdutQuantity().equals(5));
    }
    @Test
    public void verifyAtLeastOneProductTest() //Test 3
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        //homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        Integer productsAdded = cartpage.getCartProducts().size();
        cartpage.clickCheckoutButton();

        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",cartpage.getTitlePageText());
        Assert.assertTrue(productsAdded>0);

    }
    @Test
    public void verifyBlankInformationErrorMessage() //Test 5
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        cartpage.clickCheckoutButton();
        cartpage.clickContinueButton();
        Assert.assertEquals("Error: First Name is required",cartpage.getInformationUserErrorMessage());

    }
    @Test
    public void verifyAcceptedUserInformation() //Test 6
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        cartpage.clickCheckoutButton();
        cartpage.setFirstName("-");
        cartpage.setLastName("5");
        cartpage.setZipCode("a");
        cartpage.clickContinueButton();
        Assert.assertFalse(cartpage.getTitlePageText().equals("CHECKOUT: OVERVIEW"));

    }


}
