package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userNamefield = By.name("username");
    private By passWordfield = By.name("password");
    private By loginButton = By.xpath("//button[@type = 'submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String userName){
        var element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(userNamefield));
        element.clear();
        element.sendKeys(userName);
    }

    public void enterPassword(String passWord){
        var element = wait.until(ExpectedConditions.visibilityOfElementLocated(passWordfield));
        element.clear();
        element.sendKeys(passWord);
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void login(String userName, String passWord){
        enterUsername(userName);
        enterPassword(passWord);
        clickLogin();
    }

    private By invalidCredentialMessage = By.xpath("//p[text() = 'Invalid credentials']");

    public String getInvalidCredentialMessage(){
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(invalidCredentialMessage)).getText();
    }
}
