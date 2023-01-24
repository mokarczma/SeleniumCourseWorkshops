package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    public WebDriver driver;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//button[contains(@class, 'btn btn-touchspin js-touchspin bootstrap-touchspin-up')]")
    private WebElement quantityIncreaser;

    @FindBy(className ="add")
    private WebElement addToCartButton;

    @FindBy(xpath ="//*[contains(text(),'Proceed to checkout')]")
    private WebElement checkoutButton;
    public void chooseSize (String size)
    {
        Select sizeSelect = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
        sizeSelect.selectByValue(size);
    }
    public void increaseQuantity(int quantity)
    {
        for (int i = 1; i < quantity; i++) {
            quantityIncreaser.click();
        }
    }

    public void addToCart()
    {
        addToCartButton.click();
    }

    public void checkout()
    {
        checkoutButton.click();
    }
}

