package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by USER on 21.09.2014.
 */
public class CodenvyDocsPage {

    private interface Locator {
        String TITLE = "Support | Codenvy";
        String PARAGRAPH = "div.column.col65 > p";
        String TAGE_NAME_OF_ALL_PARAGRAPH = "p";
    }

    @FindBy(css = Locator.PARAGRAPH)
    private WebElement paragraphHowTo;

    @FindBy(tagName = Locator.TAGE_NAME_OF_ALL_PARAGRAPH)
    private List<WebElement> paragraphs;

    public void checkTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.titleContains(Locator.TITLE));
    }

    public void findFirstParagraph(String text) {
        new WebDriverWait(DriverManager.getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElement(paragraphHowTo, text));
    }

    public void textExistInAnyParagraph(String text) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("p")));

        boolean isExist = false;
        for(WebElement webElement: paragraphs) {
            if(isExist = webElement.getText().contains(text)) {
                break;
            }
        }
        assertTrue(isExist);
    }
}
