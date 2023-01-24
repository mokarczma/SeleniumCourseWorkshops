package myStore;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class OrderConfirmationPage {

    public WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Boolean orderExists() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        return driver.findElement(By.xpath("//h3[contains(text(),'Order items')]")).isDisplayed();
    }
}
