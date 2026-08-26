package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void verifyOrangeHRMTitle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"OrangeHRM");
        driver.quit();
    }
}
