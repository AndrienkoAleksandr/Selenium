package com.example.selenium.pagefactorywithanotation;

import com.example.selenium.pagefactorywithanotation.driver.Browser;
import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import com.example.selenium.pagefactorywithanotation.factory.PF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyCreateProjectTest {

    private WebDriver driver;

    @Before
    public void init() {
        DriverManager.setDriver(Browser.GOOGLE_CHROME);
        driver = DriverManager.getDriver();
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Test
    public void createSimpleCodenvyProjectBuildAndDelete() {
        driver.get("https://codenvy.com/site/login");

        PF.getCodenvyLoginPage().checkTitle();

        PF.getCodenvyLoginPage().setEmail("logarifm6@meta.ua");

        PF.getCodenvyLoginPage().setPassword("metan");

        PF.getCodenvyLoginPage().logIn();

        PF.getCodenvyIDEPage().checkIDELoaded();

        PF.getCodenvyIDEPage().selectCreateNewProjectInDropDown();

        PF.getCodenvyIDEPage().checkLaunchOfeXoCreateNewProjectView();
    }
}
