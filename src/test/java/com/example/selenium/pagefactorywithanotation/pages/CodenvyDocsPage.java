package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertTrue;

/**
 * Created by USER on 21.09.2014.
 */
public class CodenvyDocsPage {

    private interface Locator {
        String TITLE = "Support | Codenvy";
                            //div[h4[contains(text(), 'Free')]]//p[1]
        String PARAGRAPH = ".//*[@id='post-225']//div[@class = 'entry-content']//p[1]";
        String ALL_PARAGRAPH_OF_DOC_PAGE = ".//*[@id='post-225']//div[@class = 'entry-content']//p";
        String LINK_DEVELOPER_PUBLIC_CLOUD = "Developer Public Cloud";
        String DROP_DOWN_PRODUCTS = "#menu-item-215 > a";
    }

    @FindBy(xpath = Locator.PARAGRAPH)
    private WebElement paragraphHowTo;

    @FindBy(css = Locator.DROP_DOWN_PRODUCTS)
    private WebElement dropDownProducts;

    @FindBy(linkText = Locator.LINK_DEVELOPER_PUBLIC_CLOUD)
    private WebElement linkDeveloperCloud;

    public void checkTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.titleContains(Locator.TITLE));
    }

    public void findFirstParagraph(String text) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.PARAGRAPH)));

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(paragraphHowTo, text));
    }

    public void textExistInAnyParagraph(String text) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        String searchXPathAttribute = "[contains(text(), '" + text + "')]";
        webDriverWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(Locator.ALL_PARAGRAPH_OF_DOC_PAGE + searchXPathAttribute)));
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
