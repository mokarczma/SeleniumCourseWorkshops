package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainBarPage {
    public WebDriver driver;

    public MainBarPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//header//a[contains(text(),'Clothes')]")
    private WebElement clothesLink;

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement signInLink;

    public void goToClothesPage() {
        clothesLink.click();
    }

    public void goToSignIn() {
        signInLink.click();
    }
}
