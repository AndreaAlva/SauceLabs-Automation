package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Cartpage {
    WebDriver driver;
    @FindBy(id="checkout")
    WebElement checkoutButton;
    @FindBy(className="header_secondary_container")
    WebElement titleText;
    @FindBy(className = "cart_quantity")
    WebElement cartQuantityBox;
    @FindBy(className = "cart_item")
    List<WebElement> cartProducts;
    @FindBy(tagName = "h3")
    WebElement errorMessage;

    @FindBy(id="first-name")
    WebElement firstNameTextBox;
    @FindBy(id="last-name")
    WebElement lastNameTextBox;
    @FindBy(id="postal-code")
    WebElement zipTextBox;

    @FindBy(id="continue")
    WebElement continueButton;

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartProductsList;
    @FindBy(className = "inventory_item_price")
    List<WebElement> cartProductsPrices;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikelight;

    public Cartpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCheckoutButton() {checkoutButton.click();}
    public String getTitlePageText()
    {
        return titleText.getText();
    }
    public String getProdutQuantity() {return cartQuantityBox.getText();}
    public void setQuantity(Integer quantity)
    {
        cartQuantityBox.sendKeys(quantity.toString());
    }
    public List<WebElement> getCartProducts()
    {
        return  cartProducts;
    }
    public String getInformationUserErrorMessage()
    {
        return errorMessage.getText();
    }
    public void setFirstName(String firstname) {firstNameTextBox.sendKeys(firstname);}
    public void setLastName(String lastname) {lastNameTextBox.sendKeys(lastname);}
    public void setZipCode(String zipcode) {zipTextBox.sendKeys(zipcode);}
    public void clickContinueButton(){continueButton.click();}

    public List<String> getCartProductsList()
    {
        List<String> items=new ArrayList<>();
        for(WebElement item: cartProductsList)
        {
            String itemPriceText = item.getText();
            items.add(itemPriceText);

        }
        return items;
    }
    public List<String> getCartProductsPricesList()
    {
        List<String> items=new ArrayList<>();
        for(WebElement item: cartProductsPrices)
        {
            String itemPriceText = item.getText();
            items.add(itemPriceText);

        }
        return items;
    }
    public void removeProducts()
    {
        removeBackpack.click();
        removeBikelight.click();
    }
}
