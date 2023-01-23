package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPage {

    public WebDriver driver;

    public AuthenticationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "field-email")
    private WebElement loginEmailAdress;

    @FindBy(id = "field-password")
    private WebElement loginPassword;

    @FindBy(id = "submit-login")
    private WebElement SignInButton;

    public void signIn (String emailAdress, String password)
    {
        loginEmailAdress.sendKeys(emailAdress);
        loginPassword.sendKeys(password);
        SignInButton.click();
    }
}
