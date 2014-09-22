package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyIDEPage {

    private interface Locator {
        String EXO_BARS = "exo-menuBarItem";
        String EXO_BAR_PROJECT = "body > div:nth-child(8) > div:nth-child(2) > div > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2)";
        String NEW_ITEM = "topmenu/Project/New";
        String CREATE_ITEM = "topmenu/Project/New/Create Project...";
        String EXO_CREATE_NEW_PROJECT_VIEW = "eXoCreateNewProjectView-window";
    }

    @FindBy(className = Locator.EXO_BARS)
    private List<WebElement> exoBarsList;

    @FindBy(css = Locator.EXO_BAR_PROJECT)
    private WebElement exoBarProject;

    @FindBy(id = Locator.NEW_ITEM)
    private WebElement newItem;

    @FindBy(id = Locator.CREATE_ITEM)
    private WebElement createItem;

    @FindBy(id = Locator.EXO_CREATE_NEW_PROJECT_VIEW)
    private WebElement exoCreateNewProjectView;

    public void checkIDELoaded() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 60);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(Locator.EXO_BARS)));

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(exoBarsList));
    }

    public void selectCreateNewProjectInDropDown() {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(exoBarProject).build().perform();
        exoBarProject.click();

        action.moveToElement(newItem).build().perform();

        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.CREATE_ITEM)));
        action.moveToElement(createItem).build().perform();

        createItem.click();
    }

    public void checkLaunchOfeXoCreateNewProjectView() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.EXO_CREATE_NEW_PROJECT_VIEW)));
    }
}
