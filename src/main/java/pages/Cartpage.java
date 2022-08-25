package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
    WebDriver driver;
    @FindBy(id="checkout")
    WebElement checkoutButton;
    @FindBy(className="header_secondary_container")
    WebElement informationTest;
    public Cartpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCheckoutButton() {checkoutButton.click();}
    public String getInformationPageText()
    {
        return informationTest.getText();
    }
}
