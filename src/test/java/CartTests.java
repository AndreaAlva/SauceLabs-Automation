import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.Cartpage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;

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
    @Test
    public void verifyAddingRemovingTest()
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickBikeLight();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        List<String> products = cartpage.getCartProductsList();
        List<String> prices = cartpage.getCartProductsPricesList();
        Assert.assertEquals("Sauce Labs Backpack", products.get(0));
        Assert.assertEquals("Sauce Labs Bike Light", products.get(1));

        Assert.assertEquals("$29.99", prices.get(0));
        Assert.assertEquals("$9.99", prices.get(1));

        Assert.assertEquals("2",homepage.getNumberCart());

        cartpage.removeProducts();
        Assert.assertTrue(cartpage.getCartProductsList().size()==0);
        Assert.assertTrue(homepage.getNumberCart().equals(""));



    }


}
