package com.example.selenium.pagefactorywithanotation.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyProductsPage extends AbstractPage{

    private interface Locator {
        String TITLE = "Codenvy | Fast and Secure SAAS Developer Environments";
    }

    public void checkTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(driver(), 10);
        webDriverWait.until(ExpectedConditions.titleIs(Locator.TITLE));
    }
}
