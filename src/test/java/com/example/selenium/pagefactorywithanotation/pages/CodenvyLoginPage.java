package com.example.selenium.pagefactorywithanotation.pages;

import com.example.selenium.pagefactorywithanotation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyLoginPage {

    private interface Locator {
        String EMAIL = "email";
        String PASSWORD = "password";
        String SUBMIT = "body > div > div > div.span8 > div > form > div:nth-child(3) > input";
        String TITLE = "Codenvy - Login";
    }

    @FindBy(name = Locator.EMAIL)
    private WebElement email;

    @FindBy(name = Locator.PASSWORD)
    private WebElement password;

    @FindBy(css = Locator.SUBMIT)
    private WebElement submit;

    public void checkTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.titleContains(Locator.TITLE));
    }


    public void setEmail(String email) {
        WebDriverWait webDriverWait =  new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(Locator.EMAIL)));
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        WebDriverWait webDriverWait =  new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(Locator.EMAIL)));
        this.password.sendKeys(password);
    }

    public void logIn() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Locator.SUBMIT)));
        submit.click();
    }
}
