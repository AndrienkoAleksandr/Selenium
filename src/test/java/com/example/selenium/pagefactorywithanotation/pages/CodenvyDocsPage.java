package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        String LINK_DEVELOPER_PUBLIC_CLOUD = "Developer Public Cloud";
        String DROP_DOWN_PRODUCTS = "#menu-item-215 > a";
    }

    @FindBy(css = Locator.PARAGRAPH)
    private WebElement paragraphHowTo;

    @FindBy(tagName = Locator.TAGE_NAME_OF_ALL_PARAGRAPH)
    private List<WebElement> paragraphs;

    @FindBy(css = Locator.DROP_DOWN_PRODUCTS)
    private WebElement dropDownProducts;

    @FindBy(linkText = Locator.LINK_DEVELOPER_PUBLIC_CLOUD)
    private WebElement linkDeveloperCloud;

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

    public void clickLinkDeveloperPublicCloud() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(Locator.DROP_DOWN_PRODUCTS)));

        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(dropDownProducts).build().perform();

        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(Locator.LINK_DEVELOPER_PUBLIC_CLOUD)));
        linkDeveloperCloud.click();
    }
}
