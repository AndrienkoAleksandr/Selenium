package com.example.selenium.pagefactorywithanotation.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by logarifm on 19.09.14.
 */
public class DriverManager {

   private static WebDriver webDriver;

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void setDriver(Browser browser) {
        if (browser.equals(Browser.FIREFOX)) {
            if (Platform.getCurrent() == Platform.LINUX) {
                System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
            }
            webDriver = new FirefoxDriver();
        }
        if (browser.equals(Browser.GOOGLE_CHROME)) {
            if (Platform.getCurrent() == Platform.LINUX) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            }
            if (Platform.getCurrent() == Platform.VISTA) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            }
            webDriver = new ChromeDriver();
        }
        if (webDriver != null) {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
