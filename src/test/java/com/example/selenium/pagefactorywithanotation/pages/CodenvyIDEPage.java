package com.example.selenium.pagefactorywithanotation.pages;

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
public class CodenvyIDEPage extends AbstractPage{

    private String projectName;

    private interface Locator {
        String EXO_BARS = "exo-menuBarItem";

        String EXO_BAR_PROJECT = "//td[text()='Project' and @class='exo-menuBarItem']";

        String EXO_BAR_PROJECT_OPENED = "//td[nobr[@id='topmenu/Project/New']]";

        String NEW_ITEM = "topmenu/Project/New";

        String CREATE_ITEM = "topmenu/Project/New/Create Project...";

        String EXO_CREATE_NEW_PROJECT_VIEW = "eXoCreateNewProjectView-window";

        String PROJECT_NAME_INPUT = "eXoCreateNewProjectViewNameField";

        String PROJECT_TECHNOLOGY = "CREATE-PROJECT-Jar";

        String BUTTON_NEXT = "#eXoCreateNewProjectViewNextButton > table > " +
                "tbody > tr > td.GBI2UT5DPX > table > tbody > tr > td.GBI2UT5DBY";

        String PROJECT_EXAMPLE = "//div[text()='Simple JAR project.']";

        String BUTTON_FINISH = "#eXoCreateNewProjectViewFinishButton > table >" +
                " tbody > tr > td.GBI2UT5DPX > table > tbody > tr > td.GBI2UT5DBY";

        String PROJECT_MENU = "//td[text()='Project' and @class='exo-menuBarItem']";

        String PROJECT_MENU_OVER = "//td[text()='Project' and @class='exo-menuBarItemOver']";

        String PROJECT_MENU_OPENED = "//td[text()='Project' and @class='exo-menuBarItemSelected']";

        String BUILD_ITEM = "topmenu/Project/Build";

        String BUILD_PROJECT_PANEL ="#operation > div:nth-child(2) > table > tr > " +
                "td:nth-child(1) > div > div.gwt-TabLayoutPanelTab.GBI2UT5DEK.gwt-" +
                "TabLayoutPanelTab-selected > div > div > table > tbody > tr > " +
                "td:nth-child(2) > table > tbody > tr > td.tabTitleText";

        String BUILD_PROJECT_PANEL_RESULT = "ide.builder.buildOutput";

        String BUILD_ITEM_CLOSE = "topmenu/Project/Close";

        String BUTTON_DELETE = "//div[@title=\"Delete Item(s)...\"]";

        String DELETE_DIALOG = "ideDeleteItemsView-window";

        String BUTTON_DELETE_YES = "//div[@id=\"ideDeleteItemsView-window\"]//td[text()='Yes']";
    }

    @FindBy(className = Locator.EXO_BARS)
    private List<WebElement> exoBarsList;

    @FindBy(xpath = Locator.EXO_BAR_PROJECT)
    private WebElement exoBarProject;

    @FindBy(xpath = Locator.EXO_BAR_PROJECT_OPENED)
    private WebElement exoBarProjectOpened;

    @FindBy(id = Locator.NEW_ITEM)
    private WebElement newItem;

    @FindBy(id = Locator.CREATE_ITEM)
    private WebElement createItem;

    @FindBy(id = Locator.EXO_CREATE_NEW_PROJECT_VIEW)
    private WebElement exoCreateNewProjectView;

    @FindBy(name = Locator.PROJECT_NAME_INPUT)
    private WebElement projectNameInput;

    @FindBy(id = Locator.PROJECT_TECHNOLOGY)
    private WebElement projectTechnology;

    @FindBy(css = Locator.BUTTON_NEXT)
    private WebElement buttonNext;

    @FindBy(xpath = Locator.PROJECT_EXAMPLE)
    private WebElement projectExample;

    @FindBy(css = Locator.BUTTON_FINISH)
    private WebElement buttonFinish;

    @FindBy(xpath = Locator.PROJECT_MENU)
    private WebElement projectMenu;

    @FindBy(xpath = Locator.PROJECT_MENU_OVER)
    private WebElement projectMenuOVER;

    @FindBy(xpath = Locator.PROJECT_MENU_OPENED)
    private WebElement projectMenuOpened;

    @FindBy(id = Locator.BUILD_ITEM)
    private WebElement buildItem;

    @FindBy(css = Locator.BUILD_PROJECT_PANEL)
    private WebElement buildProjectPanel;

    @FindBy(id = Locator.BUILD_PROJECT_PANEL_RESULT)
    private WebElement buildProjectPanelResult;

    @FindBy(xpath = Locator.BUTTON_DELETE)
    private WebElement buttonDelete;

    @FindBy(id = Locator.DELETE_DIALOG)
    private WebElement dialogDelete;

    @FindBy(xpath = Locator.BUTTON_DELETE_YES)
    private WebElement buttonDeleteYes;

    public void checkIDELoaded() {
        WebDriverWait webDriverWait = new WebDriverWait(driver(), 60);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(Locator.EXO_BARS)));

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(exoBarsList));
    }

    public void selectCreateNewProjectInMenyProject() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.EXO_BAR_PROJECT)));
        exoBarProject.click();

        webdriverWait.
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.EXO_BAR_PROJECT_OPENED)));
        exoBarProjectOpened.click();

        webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.CREATE_ITEM)));
        Actions action = new Actions(driver());
        action.moveToElement(createItem).build().perform();

        createItem.click();
    }

    public void checkLaunchOfeXoCreateNewProjectView() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locator.EXO_CREATE_NEW_PROJECT_VIEW)));
    }

    public void setProjectName(String name) {
        projectName = name;
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(Locator.PROJECT_NAME_INPUT)));
        projectNameInput.clear();
        projectNameInput.sendKeys(name);
    }

    public void chooseTechnologyProjectJar() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.PROJECT_TECHNOLOGY)));
        projectTechnology.click();
    }


    public void pressNextButton() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUTTON_NEXT)));
        buttonNext.click();
    }

    public void chooseProjectExample() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.PROJECT_EXAMPLE)));
        projectExample.click();
    }

    public void pressFinishButton() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 10);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUTTON_FINISH)));
        buttonFinish.click();
    }

    public void selectBuildInMenuProject() {
        WebDriverWait webDriverWait = new WebDriverWait(driver(), 20);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(Locator.EXO_BARS)));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(exoBarsList));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.PROJECT_MENU)));
        Actions action = new Actions(driver());
        action.moveToElement(projectMenu).build().perform();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.PROJECT_MENU_OVER)));
        projectMenuOVER.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.PROJECT_MENU_OPENED)));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.BUILD_ITEM)));
        buildItem.click();
    }

    public void checkSuccessBuildingProject() {
        WebDriverWait webdriverWait = new WebDriverWait(driver(), 120);
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.BUILD_PROJECT_PANEL)));
        buildProjectPanel.click();
        ExpectedConditions.textToBePresentInElement(buildProjectPanelResult, "Successful");
    }

    public void deleteCreatedProject() {
        String locatorProjectName =
                ".//div[@id=\"idePackageExplorerTreeGrid\"]//table//div[@class=\"ide-Tree-label\" and text()='" + projectName + "']";

        WebDriverWait webDriverWait = new WebDriverWait(driver(), 10);
        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath(locatorProjectName)));
        WebElement projectFolder = driver().
                findElement(By.xpath(locatorProjectName));
        projectFolder.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.BUTTON_DELETE)));
        buttonDelete.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator.DELETE_DIALOG)));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator.BUTTON_DELETE_YES)));
        buttonDeleteYes.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Locator.DELETE_DIALOG)));
    }
}
