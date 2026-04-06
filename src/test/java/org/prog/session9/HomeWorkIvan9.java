package org.prog.session9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class HomeWorkIvan9 {
    private WebDriver driver;

    @BeforeSuite
    private void beforeSuite() {
        driver = new ChromeDriver();
    }

   @Test
   private void test() {
       driver.get("https://allo.ua");
       WebElement searchInput = driver.findElement(By.id("search-form__input"));
       searchInput.click();
       searchInput.sendKeys("iphone");
       WebElement submitButton = driver.findElement(By.className("search-form__submit-button"));
       submitButton.click();
       List<WebElement>  iphoneElements = driver.findElements(By.className("product-card"));

       if (iphoneElements.isEmpty()) {
           return;
       }

       WebElement first = iphoneElements.get(0);
       WebElement title = first.findElement(By.className("product-card__title"));
       Assert.assertNotNull(title);
   }

    @AfterSuite
    private void afterSuite() {
        driver.quit();
    }
}