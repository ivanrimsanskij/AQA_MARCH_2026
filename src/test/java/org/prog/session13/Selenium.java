package org.prog.session13;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.time.Duration;
import java.util.List;

public class Selenium {

    public static WebDriver driver;
    public static AlloPage3 alloPage;
    public static Connection connection;

    @Given("I request {int} iphones from Allo.ua")
    public void requestingIphones(int amount) {
        alloPage.loadPage();

        WebElement input = alloPage.clickOnSearchInput();
        alloPage.pasteValue(input, "iphone");
        alloPage.clickOnSubmitButton();

        WebDriverWait wait = new WebDriverWait(alloPage.driver, Duration.ofSeconds(25L));

        wait.until(d -> {
            List<WebElement> codes = d.findElements(By.className("product-sku__value"));
            return !codes.isEmpty() && !codes.get(0).getText().isEmpty();
        });

        List<String> codes = alloPage.hasItemCode("product-sku__value", amount);
        List<String> names = alloPage.hasNameProduct("product-card__title", amount);
        
        DataManager.DATA.put("iphone_codes", codes);
        DataManager.DATA.put("iphone_names", names);
    }
}