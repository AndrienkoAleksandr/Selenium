package com.example.selenium.pagefactorywithanotation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    private interface Locator {
        String TEXT_BOX = "gbqfq";
        String BUTTON_SUBMIT = "gbqfb";
    }

    @FindBy(id = Locator.TEXT_BOX)
    private WebElement textBox;

    @FindBy(id = Locator.BUTTON_SUBMIT)
    private WebElement buttonSubmit;

    public void addSearchRequest(String text) {
        textBox.sendKeys(text);
    }

    public void submit() {
        buttonSubmit.submit();
    }
}