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
        DriverManager.setDriver(Browser.GOOGLE_CHROME);
        driver = DriverManager.getDriver();
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Test
    public void testGoogleSearchAndCodenvyDocs() {
        driver.get("http://google.com");

        PF.getGoogleSearchPage().addSearchRequest("codenvy");

        PF.getGoogleSearchPage().submit();

        PF.getGoogleResultPage().findResultAndClick();

        PF.getCodenvyMainPage().clickSupportLink();

        PF.getCodenvyDocsPage().checkTitle();

        PF.getCodenvyDocsPage().findFirstParagraph("We offer free community support on our");

        PF.getCodenvyDocsPage().textExistInAnyParagraph("We offer premium email support for Early Access Program,");

        PF.getCodenvyDocsPage().clickLinkDeveloperPublicCloud();

        PF.getCodenvyProductsPage().checkTitle();
    }
}
