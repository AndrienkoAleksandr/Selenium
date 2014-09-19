package com.example.selenium.firsttest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SeleniumTestJavaFireFox {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        if (Platform.getCurrent() == Platform.LINUX) {
            System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
        }

        driver = new FirefoxDriver();
        baseUrl = "file:/home/logarifm/selenium/Selenium/training.html";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testFirstTestJava() throws Exception {
        driver.get(baseUrl);
        WebElement webElement = driver.findElement(By.id("btnAlert"));
        webElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("А я модальное!", closeAlertAndGetItsText());
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Диалоговое окно закрыто[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testOpenGoogleCom() {
        driver.get("http://www.google.com.ua/?gfe_rd=cr&ei=ez4bVNT8FJSkwAOqyIHwBg");
        System.out.println(driver.getCurrentUrl());
        driver.get(driver.getCurrentUrl());
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("gbqfq")));
        WebElement input = driver.findElement(By.id("gbqfq"));
        input.sendKeys("codenvy");
        input.sendKeys(Keys.CANCEL);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("gbqfb")));
        WebElement buttonSearch = driver.findElement(By.id("gbqfb"));
        buttonSearch.click();
        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.linkText("Codenvy | SAAS Developer Environments")));
        WebElement link = driver.findElement(By.linkText("Codenvy | SAAS Developer Environments"));
        link.click();
    }

    @Test
    public void testExUa() throws InterruptedException {
        driver.get("http://www.ex.ua/ru/software");
        WebElement element = driver.findElement(By.linkText("Программы для Windows"));
        element.click();
        assertEquals(driver.getCurrentUrl(), "http://www.ex.ua/50895?r=23781");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
