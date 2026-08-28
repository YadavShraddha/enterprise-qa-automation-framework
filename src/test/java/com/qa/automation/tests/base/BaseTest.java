package com.qa.automation.tests.base;

import com.qa.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import com.qa.automation.factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.automation.config.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));
        driver = DriverFactory.createWebdriver(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
