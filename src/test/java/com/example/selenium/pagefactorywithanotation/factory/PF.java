package com.example.selenium.pagefactorywithanotation.factory;

import com.example.selenium.pagefactorywithanotation.pages.GoogleResultPage;
import com.example.selenium.pagefactorywithanotation.pages.GoogleSearchPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

/**
 * Created by logarifm on 19.09.14.
 */
public class PF {

    private static GoogleSearchPage googleSearchPage;

    private static WebDriver driver;
    private static GoogleResultPage googleResultPage;

    public static  WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static GoogleSearchPage getGoogleSearchPage() {
        if (googleSearchPage == null) {
            googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        }
        return googleSearchPage;
    }

    public static GoogleResultPage getGoogleResultPage() {
        if (googleResultPage == null) {
            googleResultPage = PageFactory.initElements(driver, GoogleResultPage.class);
        }
        return googleResultPage;
    }
}
