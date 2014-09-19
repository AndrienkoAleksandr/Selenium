package com.example.selenium.pagefactorywithanotation.factory;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.pages.GoogleResultPage;
import com.example.selenium.pagefactorywithanotation.pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by logarifm on 19.09.14.
 */
public class PF {

    private static GoogleSearchPage googleSearchPage;
    private static GoogleResultPage googleResultPage;

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
}
