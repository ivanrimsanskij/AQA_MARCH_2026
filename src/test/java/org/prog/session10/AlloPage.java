package org.prog.session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class AlloPage {
    public WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public WebElement clickOnSearchInput() {
        WebElement searchInput = driver.findElement(By.id("search-form__input"));
        searchInput.click();

        return searchInput;
    }

    public void pasteValue(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void clickOnSubmitButton() {
        WebElement submitButton = driver.findElement(By.className("search-form__submit-button"));
        submitButton.click();
    }

    public List<WebElement> getIphoneElements() {
        return driver.findElements(By.className("product-card"));
    }

    public boolean hasItemCode(List<WebElement> iphoneElements) {
        Actions actions = new Actions(driver);

        return iphoneElements.stream()
            .limit(3)
            .allMatch(item -> {
                actions.moveToElement(item).perform();

                WebElement codeElement = item.findElement(By.className("product-sku__value"));
                String itemCode = codeElement.getText();

                return itemCode != null && !itemCode.isEmpty();
            });
    }
}