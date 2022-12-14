package com.example.jenkinstestconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondSeleniumJavaTest {
    private WebDriver driver;
    String browser = System.getProperty("browser");

    @Test
    public void testEasy(){
        driver.get("https://google.com.sv");
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void beforeTest() {
        switch(browser) {
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            default:
                driver = WebDriverManager.chromedriver().create();
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
