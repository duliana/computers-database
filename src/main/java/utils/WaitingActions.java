package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingActions {

    public WebDriver waDriver;

    public WaitingActions(WebDriver driver){
        waDriver = driver;
    }

    static JavascriptExecutor jsDriver = null;

    public void pageLoadComplete() {
        jsDriver = (JavascriptExecutor)waDriver;
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return jsDriver.executeScript("return document.readyState", true).toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(waDriver, 200);
            wait.until(expectation);
        } catch (Throwable error) {
        }
    }

    public void jQueryComplete() {

        jsDriver = (JavascriptExecutor)waDriver;
        try{
            jsDriver.executeScript("window.jQuery");
            if (jsDriver.executeScript("return jQuery.active").toString().equals("0")) {
                return;
            }

            for (int i = 0; i < 25; i++) {
                Thread.sleep(500);
                System.out.println("i "+i);
                if (jsDriver.executeScript("return jQuery.active").toString().equals("0")) {
                    break;
                }
            }
        }catch(Exception e){

        }

    }

}
