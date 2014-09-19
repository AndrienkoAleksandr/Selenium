package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.factory.PF;
import com.example.selenium.pagefactorywithanotation.pages.GoogleResultPage;
import com.example.selenium.pagefactorywithanotation.pages.GoogleSearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

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
        PF.setDriver(driver);
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://google.com");

        PF.getGoogleSearchPage().addSearchRequest("codenvy");

        PF.getGoogleSearchPage().submit(driver);

        PF.getGoogleResultPage().resultIsExist();
    }
}
