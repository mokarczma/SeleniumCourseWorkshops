package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//*[contains(text(),'Proceed to checkout')]")
    private WebElement checkoutButton;

    @FindBy(xpath ="//button[@name='confirm-addresses']")
    private WebElement confirmAddressesButton;

    @FindBy(xpath ="//button[@name='confirmDeliveryOption']")
    private WebElement confirmDeliveryOptionButton;

    @FindBy(xpath ="//input[@id='payment-option-1']")
    private WebElement payByCheckCheckBox;

    @FindBy(id ="conditions_to_approve[terms-and-conditions]")
    private WebElement agreeCheckBox;

    @FindBy(xpath ="//button[contains(text(),'Place order')]")
    private WebElement placeOrderButton;

    public void checkout()
    {
        checkoutButton.click();
    }

    public void confirmOrder()
    {
        confirmAddressesButton.click();
        confirmDeliveryOptionButton.click();
        payByCheckCheckBox.click();
        agreeCheckBox.click();
        placeOrderButton.click();
    }

}
