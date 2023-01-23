package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myStore.AuthenticationPage;
import myStore.MyAccountPage;
import myStore.MyAddressesPage;
import myStore.NewAddressPage;
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
        authenticationPage.signIn("jxfzghimqynrdpsvvc@tmmbt.com", "test123");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAdressPage();
        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.goToNewAdressPage();
    }

    @When("new address add")
    public void newAddressAdd() {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAdress("12","Jasna 3", "Warszawa", "02-781", "123456789");
    }

    @Then("address is added")
    public void addressIsAdded() {
        var aa = "Monia";
    }

    @And("close browser")
    public void closeBrowser() {
        this.driver.quit();
    }

}

