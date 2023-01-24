package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myStore.AuthenticationPage;
import myStore.MyAccountPage;
import myStore.MyAddressesPage;
import myStore.NewAddressPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStoreSteps {

    private WebDriver driver;
    @Given("an open browser with {string} and logged user")
    public void anOpenBrowserWithUrlAndLoggedUser(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn("rfhxyzmioqzrbkbgvu@tmmcv.net", "andrzej2345");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAdressPage();
        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.deleteAllAddressesWithoutMain();
        myAddressesPage.goToNewAdressPage();
    }
    @When("user type {}, {}, {}, {}, {} in the new addresses form")
    public void newAddressAdd(String alias, String  address, String  city, String  zip,  String phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAdress(alias, address, city, zip, phone);
    }

    @Then("address with alias: {} is added")
    public void addressIsAdded(String alias) {
        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        var tes = myAddressesPage.checkAddressExistsByAlias(alias);
        Assert.assertTrue(myAddressesPage.checkAddressExistsByAlias(alias));
    }

    @And("clean up and close browser")
    public void closeBrowser() {
        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.deleteAllAddressesWithoutMain();
        this.driver.quit();
    }

}

