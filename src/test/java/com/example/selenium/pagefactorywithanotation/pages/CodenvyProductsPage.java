package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyProductsPage {

    private interface Locator {
        String TITLE = "Codenvy | Fast and Secure SAAS Developer Environments";
    }

    public void checkTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.titleIs(Locator.TITLE));
    }
}
