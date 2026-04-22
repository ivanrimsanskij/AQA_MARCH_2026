package org.prog.session12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.List;

public class HomeWorkIvan12 {

    public WebDriver driver;
    public AlloPage2 alloPage;
    public Connection connection;

    @BeforeSuite
    private void beforeSuite() throws Exception {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        alloPage = new AlloPage2(driver);
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/iphones", "root", "12345");
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
    }

    @Test
    public void test2() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(d -> !alloPage.getIphoneElements().isEmpty());

        List<String> listFromPage = alloPage.hasItemCode();
        List<String> firstThreeIphones = alloPage.hasNameProduct();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO iphones (Code, name) " +
                "VALUES (?, ?)");

        for (int i = 0; i < firstThreeIphones.size(); i++) {
            preparedStatement.setString(1, listFromPage.get(i));
            preparedStatement.setString(2, firstThreeIphones.get(i));
            preparedStatement.execute();
        }

        System.out.println("WOW");
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        connection.close();
        driver.quit();
    }
}