package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by logarifm on 19.09.14.
 */
public class FirstTestCase {
    private static WebDriver driver = null;

    public static void main(String[] args) {

        if (Platform.getCurrent() == Platform.LINUX) {
            System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
        }

        // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();

        //Put a Implicit wait, this means that any search for elements on the pages could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Online Store Website

        driver.get("http://www.store.demoqa.com");

        // Find the element that's ID attribute is 'account'(My Account)

        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        // Find the element that's ID attribute is 'log' (Username)

        // Enter Username on the element found by above desc.

        driver.findElement(By.id("log")).sendKeys("testusere_1");

        // Find the element that's ID attribute is 'pwd' (Password)

        // Enter Password on the element found by the above desc.

        driver.findElement(By.id("pwd")).sendKeys("Test@123");

        // Now submit the form. WebDriver will find the form for us from the element

        driver.findElement(By.id("login")).click();

        // Find the element with error

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ajax_loginform > p.response")));

        // Print a Log In message to the screen

        System.out.println(" We blocked because we from Ukraine.");


        // Close the driver

        driver.quit();

    }

}
