package com.example.selenium.pagefactorywithanotation;

import org.junit.Test;

/**
 * Created by logarifm on 19.09.14.
 */
public class UsingGoogleSearchPage extends BaseTest{

    @Test
    public void testGoogleSearchAndCodenvyDocs() {
        driver().get("http://google.com");

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
