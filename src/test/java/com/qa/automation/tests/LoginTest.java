package com.qa.automation.tests;
import com.qa.automation.config.ConfigReader;

import com.qa.automation.pages.DashboardPage;
import com.qa.automation.pages.LoginPage;
import com.qa.automation.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void verifyOrangeHRMTitle(){
        driver.get(ConfigReader.getProperty("baseURL"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"OrangeHRM");
    }

    @Test
    public void verifyValidLogin(){
        driver.get(ConfigReader.getProperty("baseURL"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(),
                "dashboard was not displayed after successful login");
    }

    @Test
    public void verifyInvalidLogin(){

        driver.get(ConfigReader.getProperty("baseURL"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("InvalidUser","InvalidPassword");

        Assert.assertEquals(loginPage.getInvalidCredentialMessage(),"Invalid credentials",
                "Expected invalid login error message was not displayed");
    }

}