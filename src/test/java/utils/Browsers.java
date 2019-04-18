package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsers {

    private static String setUrl;

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static WebDriver driver = null;

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized void setDriver() {
        selectPath(Platform.getCurrent());
        driver = new ChromeDriver();
        setSetUrl("http://computer-database.herokuapp.com");
            tlDriver.set(driver);

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
