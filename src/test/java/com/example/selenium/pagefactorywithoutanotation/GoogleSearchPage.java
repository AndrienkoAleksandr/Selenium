package com.example.selenium.pagefactorywithoutanotation;

import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebElement gbqfq;

    private WebElement gbqfb;

    private String text;

    public void addSearchRequest(String text) {
        this.text = text;
        gbqfq.sendKeys(text);
    }

    public void submit() {
        gbqfb.submit();
    }
}