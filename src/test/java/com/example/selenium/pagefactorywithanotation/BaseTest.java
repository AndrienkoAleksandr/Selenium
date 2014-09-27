package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.driver.Browser;
import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.OurPageFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by USER on 26.09.2014.
 */
public class BaseTest {
    public OurPageFactory PF;

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DriverManager.setDriver(Browser.FIREFOX);
        driver = DriverManager.getDriver();
        PF = new OurPageFactory();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public WebDriver driver() {
        return driver;
    }
}
