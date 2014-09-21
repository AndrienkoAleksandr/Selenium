package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.driver.Browser;
import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.PF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by logarifm on 19.09.14.
 */
public class UsingGoogleSearchPage {

    private WebDriver driver;

    @Before
    public void init() {
        DriverManager.setDriver(Browser.FIREFOX);
        driver = DriverManager.getDriver();
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://google.com");

        PF.getGoogleSearchPage().addSearchRequest("codenvy");

        PF.getGoogleSearchPage().submit();


        PF.getGoogleResultPage().findResultAndClick();

        PF.getCodenvyMainPage().clickDocsLink();

        PF.getCodenvyDocsPage().goToWindowFrom(driver.getWindowHandle());

        PF.getCodenvyDocsPage().findParagraph("Learn how to:");
    }
}
