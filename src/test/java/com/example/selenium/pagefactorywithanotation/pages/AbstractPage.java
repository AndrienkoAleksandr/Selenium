package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.OurPageFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by USER on 26.09.2014.
 */
public abstract class AbstractPage {
    private WebDriver driver;
    private final OurPageFactory PF;

    AbstractPage() {
        PF = new OurPageFactory();
        driver = DriverManager.getDriver();
    }

    public WebDriver driver() {
        return driver;
    }
}
