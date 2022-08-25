package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }
    public void clickMenuButton() {menuButton.click();}
    public void clickLogoutButton() {logoutSidebarButton.click();}
    public void clickCartIcon(){cartIcon.click();}
}
