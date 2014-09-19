package com.example.selenium.pagefactorywithanotation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by logarifm on 19.09.14.
 */
public class GoogleResultPage {
    @FindBy(how = How.ID_OR_NAME, using = "Codenvy | SAAS Developer Environmentsyuyuyuy")
    private WebElement resultOfSearch;

    public WebElement findResult() {
        return resultOfSearch;
    }
}
