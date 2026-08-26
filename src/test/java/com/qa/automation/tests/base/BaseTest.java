package com.qa.automation.tests.base;

import org.openqa.selenium.WebDriver;
import com.qa.automation.factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String browser = System.getProperty("browser","chrome");
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
