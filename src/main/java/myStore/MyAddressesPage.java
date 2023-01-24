package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAddressesPage {

    public WebDriver driver;

    public MyAddressesPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[contains(text(),'Create new address')]")
    private WebElement createAddress;

    @FindBy(xpath = "//div[@class=\"address-body\"]/h4")
    private List<WebElement> addressAliases;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private List<WebElement> deleteList;

    public void goToNewAdressPage() {
        createAddress.click();
    }

    public Boolean checkAddressExistsByAlias (String alias)
    {
        return addressAliases.get(1).getText().contains(alias);
    }
    public void deleteAllAddressesWithoutMain()
    {
        if (deleteList != null)
        {
            for (int i = deleteList.size() -1; i >= 1; i--) {
                deleteList.get(i).click();
            }
        }
    }
}
