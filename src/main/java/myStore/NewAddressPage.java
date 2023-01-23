package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    public WebDriver driver;

    public NewAddressPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "field-alias")
    private WebElement alias;

    @FindBy(id = "field-address1")
    private WebElement address;

    @FindBy(id = "field-city")
    private WebElement city;

    @FindBy(id = "field-postcode")
    private WebElement zip;

    @FindBy(id = "field-id_country")
    private WebElement countryDropdown;

    @FindBy(xpath = "//*[ text() = \"United Kingdom\" ]")
    private WebElement countryOption;

    @FindBy(id = "field-phone")
    private WebElement phone;

    @FindBy( xpath= "//*[contains(@class, \"btn btn-primary form-control-submit float-xs-right\")]")
    private WebElement saveButton;

    public void addNewAdress (String aliasV, String addressV, String cityV, String zipV, String phoneV)
    {
        alias.sendKeys(aliasV);
        address.sendKeys(addressV);
        city.sendKeys(cityV);
        zip.sendKeys(zipV);
        countryDropdown.click();
        countryOption.click();
        phone.sendKeys(phoneV);
        saveButton.click();
    }
}
