package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.driver.Browser;
import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.PF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by logarifm on 19.09.14.
 */
public class UsingGoogleSearchPage {

    WebDriver driver;

    @Before
    public void init() {
        DriverManager.setDriver(Browser.GOOGLE_CHROME);
        driver = DriverManager.getDriver();
    }

    @After
    public void clearUp() {
        DriverManager.getDriver().quit();
    }

    @Test
    public void testGoogleSearch() {
        DriverManager.getDriver().get("http://google.com");

        PF.getGoogleSearchPage().addSearchRequest("codenvy");

        PF.getGoogleSearchPage().submit();

        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Codenvy | SAAS Developer Environments")));

        WebElement link = driver.findElement(By.linkText("Codenvy | SAAS Developer Environments"));
        link.click();
    }
}
