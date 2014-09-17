package com.example.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.xml.ws.WebEndpoint;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by logarifm on 17.09.14.
 */
public class OpenGoogleSiteTest {
    private HtmlUnitDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void init() {
        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testExUa() throws InterruptedException {
        driver.get("http://www.ex.ua/ru/software");
        WebElement element = driver.findElementByLinkText("Программы для Windows");
        element.click();
        assertEquals(driver.getCurrentUrl(), "http://www.ex.ua/50895?r=23781");
    }

//    @Test
//    public void testOpenGoogleCom() {
//        driver.get("http://google.com");
//        System.out.println(driver.getCurrentUrl());
//        driver.get(driver.getCurrentUrl());driver.
//        driver.findElement(By.linkText("Поиск в Google"));
//    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
