import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.session10.AlloPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkIvan10 {
    public WebDriver driver;
    public AlloPage alloPage;

    @BeforeSuite
    private void beforeSuite() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        alloPage = new AlloPage(driver);
    }

    @Test
    public void test() {
        alloPage.loadPage();

        WebElement input = alloPage.clickOnSearchInput();
        alloPage.pasteValue(input, "iphone");

        alloPage.clickOnSubmitButton();

        WebDriverWait wait = new WebDriverWait(alloPage.driver, Duration.ofSeconds(5L));

        List<WebElement> iphoneElements = alloPage.getIphoneElements();

        if (iphoneElements.isEmpty()) {
            return;
        }

        List<WebElement> listFromPage = alloPage.getIphoneElements();
        boolean result = alloPage.hasItemCode(listFromPage);

        Assert.assertTrue(result);
    }

    @AfterSuite
    public void AfterSuite() {
        driver.quit();
    }
}