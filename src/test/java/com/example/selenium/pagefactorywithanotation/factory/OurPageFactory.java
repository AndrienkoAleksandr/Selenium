package com.example.selenium.pagefactorywithanotation.factory;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by logarifm on 19.09.14.
 */
public class OurPageFactory {

    private GoogleSearchPage googleSearchPage;
    private GoogleResultPage googleResultPage;
    private CodenvyMainPage codenvyMainPage;
    private CodenvyDocsPage codenvyDocsPage;
    private CodenvyProductsPage codenvyProductsPage;
    private CodenvyLoginPage codenvyLoginPage;
    private CodenvyIDEPage codenvyIDEPage;
    private WebDriver driver;

    public OurPageFactory() {
        driver = DriverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        return googleSearchPage = (googleSearchPage == null) ?
                PageFactory.initElements(driver, GoogleSearchPage.class) : googleSearchPage;
    }

    public GoogleResultPage getGoogleResultPage() {
        return googleResultPage = (googleResultPage == null) ?
                PageFactory.initElements(driver, GoogleResultPage.class) : googleResultPage;
    }

    public CodenvyMainPage getCodenvyMainPage(){
        return codenvyMainPage = (codenvyMainPage == null) ?
                PageFactory.initElements(driver, CodenvyMainPage.class) : codenvyMainPage;
    }

    public CodenvyDocsPage getCodenvyDocsPage() {
        return codenvyDocsPage = (codenvyDocsPage == null) ?
                PageFactory.initElements(driver, CodenvyDocsPage.class) : codenvyDocsPage;
    }

    public CodenvyProductsPage getCodenvyProductsPage() {
        return codenvyProductsPage = (codenvyProductsPage == null) ?
                PageFactory.initElements(driver, CodenvyProductsPage.class) : codenvyProductsPage;
    }

    public CodenvyLoginPage getCodenvyLoginPage() {
        return codenvyLoginPage = (codenvyLoginPage == null) ?
                PageFactory.initElements(driver, CodenvyLoginPage.class) : codenvyLoginPage;
    }

    public CodenvyIDEPage getCodenvyIDEPage() {
        return codenvyIDEPage = (codenvyIDEPage == null) ?
                PageFactory.initElements(driver, CodenvyIDEPage.class) : codenvyIDEPage;
    }
}
