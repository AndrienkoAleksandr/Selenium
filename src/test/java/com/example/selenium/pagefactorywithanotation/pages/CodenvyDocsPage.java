package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by USER on 21.09.2014.
 */
public class CodenvyDocsPage {
    private interface Locator {
        String TITLE = "User Documentation | Codenvy Docs";
        String TAG_NAME = "p";
    }

    private String OLD_WINDOW;

    private String currentWindow;

    @FindBy(tagName = "p")
    private WebElement paragraphHowTo;

    public void goToWindowFrom(String previousPageName) {
        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        tabs.remove(previousPageName);

        DriverManager.getDriver().switchTo().window(tabs.get(0));
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.titleContains(Locator.TITLE));
    }

    public void findParagraph(String text) {
        assertEquals(paragraphHowTo.getText(), text);
    }
}
