package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by USER on 21.09.2014.
 */
public class CodenvyMainPage {
    private interface Locator {
        String DOC_LINK = "SUPPORT";
    }

    @FindBy(linkText = Locator.DOC_LINK)
    private WebElement linkDocs;

    public void clickDocsLink() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Locator.DOC_LINK)));
        linkDocs.click();
    }
}
