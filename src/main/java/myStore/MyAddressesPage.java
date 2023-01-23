package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressesPage {

    public WebDriver driver;

    public MyAddressesPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[contains(text(),'Create new address')]")
    private WebElement createAddress;

    public void goToNewAdressPage() {
        createAddress.click();
    }


}
