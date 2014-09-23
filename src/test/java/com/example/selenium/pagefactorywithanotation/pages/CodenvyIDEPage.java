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

        String EXO_BAR_PROJECT = "body > div:nth-child(8) > div:nth-child(2) > " +
                "div > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2)";

        String NEW_ITEM = "topmenu/Project/New";

        String CREATE_ITEM = "topmenu/Project/New/Create Project...";

        String EXO_CREATE_NEW_PROJECT_VIEW = "eXoCreateNewProjectView-window";

        String PROJECT_NAME = "eXoCreateNewProjectViewNameField";

        String PROJECT_TECHNOLOGY = "CREATE-PROJECT-Jar";

        String BUTTON_NEXT = "#eXoCreateNewProjectViewNextButton > table > " +
                "tbody > tr > td.GBI2UT5DPX > table > tbody > tr > td.GBI2UT5DBY";

        String PROJECT_EXAMPLE = "#eXoCreateNewProjectView-window > div > table > " +
                "tbody > tr.dialogMiddle > td.dialogMiddleCenter > div > div > " +
                "div:nth-child(2) > div > div:nth-child(2) > div > div:nth-child(2) " +
                "> div > div:nth-child(2) > div:nth-child(2) > div > div.GBI2UT5DINB > " +
                "div:nth-child(3) > div > div:nth-child(2) > div > table > " +
                "tbody:nth-child(4) > tr > td.GBI2UT5DCS.GBI2UT5DES.GBI2UT5DPS";

        String BUTTON_FINISH = "#eXoCreateNewProjectViewFinishButton > table >" +
                " tbody > tr > td.GBI2UT5DPX > table > tbody > tr > td.GBI2UT5DBY";

        String PROJECT_MENU = "/html/body/div[5]/div[2]/div/div[2]/div/table/tbody/tr/td[2]";

        String BUILD_ITEM = "topmenu/Project/Build";

        String BUILD_PROJECT_PANEL ="#operation > div:nth-child(2) > table > tr > " +
                "td:nth-child(1) > div > div.gwt-TabLayoutPanelTab.GBI2UT5DEK.gwt-" +
                "TabLayoutPanelTab-selected > div > div > table > tbody > tr > " +
                "td:nth-child(2) > table > tbody > tr > td.tabTitleText";

        String BUILD_PROJECT_PANEL_RESULT = "ide.builder.buildOutput";
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

    @FindBy(name = Locator.PROJECT_NAME)
    private WebElement projectName;

    @FindBy(id = Locator.PROJECT_TECHNOLOGY)
    private WebElement projectTechnology;

    @FindBy(css = Locator.BUTTON_NEXT)
    private WebElement buttonNext;

    @FindBy(css = Locator.PROJECT_EXAMPLE)
    private WebElement projectExample;

    @FindBy(css = Locator.BUTTON_FINISH)
    private WebElement buttonFinish;

    @FindBy(xpath = Locator.PROJECT_MENU)
    private WebElement projectMenu;

    @FindBy(id = Locator.BUILD_ITEM)
    private WebElement buildItem;

    @FindBy(css = Locator.BUILD_PROJECT_PANEL)
    private WebElement buildProjectPanel;

    @FindBy(id = Locator.BUILD_PROJECT_PANEL_RESULT)
    private WebElement buildProjectPanelResult;

    public void checkIDELoaded() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 60);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(Locator.EXO_BARS)));

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(exoBarsList));
    }

    public void selectCreateNewProjectInMenyProject() {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(exoBarProject).build().perform();
        exoBarProject.click();

        action.moveToElement(newItem).build().perform();

        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 15);
        webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.CREATE_ITEM)));
        action.moveToElement(createItem).build().perform();

        createItem.click();
    }

    public void checkLaunchOfeXoCreateNewProjectView() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.EXO_CREATE_NEW_PROJECT_VIEW)));
    }

    public void setProjectName() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(Locator.PROJECT_NAME)));
        projectName.clear();
        projectName.sendKeys("projectTest2");
    }

    public void chooseTechnologyProjectJar() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.PROJECT_TECHNOLOGY)));
        projectTechnology.click();
    }


    public void pressNextButton() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUTTON_NEXT)));
        buttonNext.click();
    }

    public void chooseProjectExample() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.PROJECT_EXAMPLE)));
        projectExample.click();
    }

    public void pressFinishButton() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUTTON_FINISH)));
        buttonFinish.click();
    }

    public void selectBuildInMenuProject() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.elementToBeClickable(projectMenu));
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(projectMenu).build().perform();
        projectMenu.click();

        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.BUILD_ITEM)));
        buildItem.click();
    }

    public void checkSuccessBuildingProject() {
        WebDriverWait webdriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUILD_PROJECT_PANEL)));
        buildProjectPanel.click();
        ExpectedConditions.textToBePresentInElement(buildProjectPanelResult, "Successful");
    }
}
