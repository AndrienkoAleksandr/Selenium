package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by logarifm on 19.09.14.
 */
public class GoogleResultPage {

    private interface Locator {
        String CODENVY_LINK = "Codenvy | SAAS Developer Environments";
    }

    @FindBy(linkText  = Locator.CODENVY_LINK)
    private WebElement resultOfSearch;

    public void findResultAndClick() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Locator.CODENVY_LINK)));

        resultOfSearch.click();
    }
}
