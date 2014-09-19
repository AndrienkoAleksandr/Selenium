package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.driver.Browser;
import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.PF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by logarifm on 19.09.14.
 */
public class UsingGoogleSearchPage {

    @Before
    public void init() {
        DriverManager.setDriver(Browser.GOOGLE_CHROME);
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

        PF.getGoogleResultPage().findResult();
    }
}
