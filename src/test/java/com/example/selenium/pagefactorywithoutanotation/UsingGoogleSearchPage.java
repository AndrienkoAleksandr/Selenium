package com.example.selenium.pagefactorywithoutanotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by logarifm on 19.09.14.
 */
public class UsingGoogleSearchPage {
    private  WebDriver driver;

    @Before
    public void init(){
        if (Platform.getCurrent() == Platform.LINUX) {
            System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
        }

        driver = new FirefoxDriver();
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://google.com");

        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        page.addSearchRequest("codenvy");
        page.submit();
    }
}
