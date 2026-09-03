package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By dashboardHeader =By.xpath("//h6[text()='Dashboard']");

    public boolean isDashboardDisplayed(){
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
}
