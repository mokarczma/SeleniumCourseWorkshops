package mystore;

import myStore.AuthenticationPage;
import myStore.ClothesPage;
import myStore.MainBarPage;
import myStore.ProductPage;
import myStore.OrderPage;
import myStore.OrderConfirmationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Orders {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl/");
        MainBarPage mainBarPage = new MainBarPage(driver);
        mainBarPage.goToSignIn();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn("rfhxyzmioqzrbkbgvu@tmmcv.net", "andrzej2345");
        mainBarPage.goToClothesPage();
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.selectProduct("Hummingbird printed sweater");
    }

    @Test
    public void shouldBuyProduct() {
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseSize("2");
        productPage.increaseQuantity(5);
        productPage.addToCart();
        productPage.checkout();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.checkout();
        orderPage.confirmOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertTrue(orderConfirmationPage.orderExists());
    }

    @After
    public void cleanup() {
        driver.quit();
    }
}
