package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Browsers {

    private static String setUrl;
    private static WebDriver driver;

    public static synchronized WebDriver getDriver() {

        selectPath(Platform.getCurrent());
        driver = new ChromeDriver();
        setSetUrl("http://computer-database.herokuapp.com");
        return driver;
    }

    protected static void selectPath(Platform platform) {
        String browser;

        browser = "webdriver.chrome.driver";
        switch (platform) {
            case MAC:
                System.setProperty(browser, "driver/chromedriver");
                break;
            case WIN10:
            case WIN8:
            case WIN8_1:
            case WINDOWS:
                System.setProperty(browser, "driver/chromedriver.exe");
                break;
            case LINUX:
                System.setProperty(browser, "driver/chromedriverlinux");
                break;
            default:
                break;
        }

    }

    public static void setSetUrl(String url) {
        setUrl = url;
    }
}
