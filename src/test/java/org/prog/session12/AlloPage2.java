package org.prog.session12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class AlloPage2 {
        public WebDriver driver;

        public AlloPage2(WebDriver driver) {
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

        public List <String> hasItemCode() {
            Actions actions = new Actions(driver);
            return getIphoneElements().stream()
                    .limit(3)
                    .map(item -> {
                        actions.moveToElement(item).perform();

                        WebElement codeElement = item.findElement(By.className("product-sku__value"));
                        return codeElement.getText();
                    })
                    .collect(Collectors.toList());
        }
        public List <String> hasNameProduct() {
            return getIphoneElements().stream()
                    .limit(3)
                    .map(item -> {
                        WebElement nameElement = item.findElement(By.className("product-card__title"));
                        return nameElement.getText();
                    })
                    .collect(Collectors.toList());

        }
    }

