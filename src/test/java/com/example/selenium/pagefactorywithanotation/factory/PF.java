package com.example.selenium.pagefactorywithanotation.factory;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by logarifm on 19.09.14.
 */
public class PF {

    private static GoogleSearchPage googleSearchPage;
    private static GoogleResultPage googleResultPage;
    private static CodenvyMainPage codenvyMainPage;
    private static CodenvyDocsPage codenvyDocsPage;
    private static CodenvyProductsPage codenvyProductsPage;
    private static CodenvyLoginPage codenvyLoginPage;
    private static CodenvyIDEPage codenvyIDEPage;

    private static WebDriver driver = DriverManager.getDriver();


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static GoogleSearchPage getGoogleSearchPage() {
        return googleSearchPage = (googleSearchPage == null) ?
                PageFactory.initElements(driver, GoogleSearchPage.class) : googleSearchPage;
    }

    public static GoogleResultPage getGoogleResultPage() {
        return googleResultPage = (googleResultPage == null) ?
                PageFactory.initElements(driver, GoogleResultPage.class) : googleResultPage;
    }

    public static CodenvyMainPage getCodenvyMainPage(){
        return codenvyMainPage = (codenvyMainPage == null) ?
                PageFactory.initElements(driver, CodenvyMainPage.class) : codenvyMainPage;
    }

    public static CodenvyDocsPage getCodenvyDocsPage() {
        return codenvyDocsPage = (codenvyDocsPage == null) ?
                PageFactory.initElements(driver, CodenvyDocsPage.class) : codenvyDocsPage;
    }

    public static CodenvyProductsPage getCodenvyProductsPage() {
        return codenvyProductsPage = (codenvyProductsPage == null) ?
                PageFactory.initElements(driver, CodenvyProductsPage.class) : codenvyProductsPage;
    }

    public static CodenvyLoginPage getCodenvyLoginPage() {
        return codenvyLoginPage = (codenvyLoginPage == null) ?
                PageFactory.initElements(driver, CodenvyLoginPage.class) : codenvyLoginPage;
    }

    public static CodenvyIDEPage getCodenvyIDEPage() {
        return codenvyIDEPage = (codenvyIDEPage == null) ?
                PageFactory.initElements(driver, CodenvyIDEPage.class) : codenvyIDEPage;
    }
}
