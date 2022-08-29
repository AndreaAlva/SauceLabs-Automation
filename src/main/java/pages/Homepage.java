package pages;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;
    @FindBy(id="react-burger-menu-btn")
    WebElement menuButton;
    @FindBy(id= "logout_sidebar_link")
    WebElement logoutSidebarButton;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutLinkButton;
    @FindBy(className = "product_sort_container")
    WebElement sortingOptionContainer;
    @FindBy (className = "inventory_item_price")
    List<WebElement> pricesLabel;

    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }
    public List<Double> getPricesList()
    {
        List<Double> prices = new ArrayList<>();
        for(WebElement itemPrice: pricesLabel)
        {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }
    public void selectProductFilter(String element)
    {
        Select selectobject = new Select(sortingOptionContainer);
        selectobject.selectByVisibleText(element);
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }
    public void clickMenuButton() {menuButton.click();}
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutSidebarButton));
        logoutSidebarButton.click();}
    public void clickCartIcon(){cartIcon.click();}
    public void clickAboutLinkButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutSidebarButton));
        aboutLinkButton.click();
    }
}
