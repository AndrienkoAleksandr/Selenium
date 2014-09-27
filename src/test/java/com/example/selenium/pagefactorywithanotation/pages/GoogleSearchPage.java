package com.example.selenium.pagefactorywithanotation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends AbstractPage {

    private interface Locator {
        String TEXT_BOX = "gbqfq";
        String BUTTON_SUBMIT = "gbqfb";
    }

    @FindBy(id = Locator.TEXT_BOX)
    private WebElement textBox;

    @FindBy(id = Locator.BUTTON_SUBMIT)
    private WebElement buttonSubmit;

    public void addSearchRequest(String text) {
        WebDriverWait webDriverWait = new WebDriverWait(driver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.TEXT_BOX)));
        textBox.sendKeys(text);
    }

    public void submit() {
        WebDriverWait webDriverWait = new WebDriverWait(driver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator.BUTTON_SUBMIT)));
        buttonSubmit.submit();
    }
}