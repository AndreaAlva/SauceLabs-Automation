import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import net.bytebuddy.description.annotation.AnnotationValue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.manipulation.Orderer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Cartpage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HomeTests extends BaseTest {

    @Test
    public void verifyCartButtonNumberIsAdded(){
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
    }
    @Test
    public void verifyCartButtonNumberIsBlankWhereThereIsNotProductsInTheCart(){
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
        Assert.assertEquals( "", homepage.getCartIconText());
    }

    @Test
    public void verificarLogOutButtonCierraSesion(){
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickMenuButton();
        homepage.clickLogoutButton();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        Assert.assertTrue(loginPage.appLogoIsDisplayed());
    }
    @Test
    public void verifyCartSymbolgoestoCartPage(){
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickMenuButton();
        homepage.clickCartIcon();
        Cartpage cartpage = new Cartpage(DriverManager.getDriver().driver);
        Assert.assertEquals("YOUR CART",cartpage.getTitlePageText());
    }
    @Test
    public void verifyHightoLowSortingTest() //Test 1
    {
        logging();
        Homepage homepage = new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Price (high to low)");
        List<Double> prices = homepage.getPricesList();
        boolean isSorted = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(isSorted);

    }
    @Test
    public void verifyAboutButtonWorks() // Test 4
    {
        logging();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickMenuButton();
        homepage.clickAboutLinkButton();
        String currenturl = DriverManager.getDriver().driver.getCurrentUrl();
        Assert.assertEquals("https://saucelabs.com/",currenturl);
    }

}
