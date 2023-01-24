package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    public WebDriver driver;

    public ClothesPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String productName) {
        driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]")).click();
    }
}
