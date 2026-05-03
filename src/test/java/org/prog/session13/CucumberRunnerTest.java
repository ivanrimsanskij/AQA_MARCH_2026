package org.prog.session13;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;

import static org.prog.session13.Selenium.connection;
import static org.prog.session13.Selenium.driver;

@CucumberOptions(
        tags = "@dbHw",
        glue = "org.prog.session13",
        features = "src/test/resources"
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    @BeforeSuite
    private void beforeSuite() throws Exception {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--headless=new");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        Selenium.alloPage = new AlloPage3(driver);
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/iphones", "root", "12345");
    }
    @AfterSuite
    public void afterSuite() throws Exception {
        connection.close();
        driver.quit();
    }
}
