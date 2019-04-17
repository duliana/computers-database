package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.Computer;
import utils.WaitingActions;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
   // protected final Logger log = Logger.getLogger(getClass());
    protected WebDriverWait wait;
    protected WaitingActions wa;
    public static Computer computer = new Computer();
    public String EMPTY="";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,15);
        this.wa = new WaitingActions(this.driver);
    }

    protected void waitAllRequest(){
        wa.pageLoadComplete();
        wa.jQueryComplete();
       // wa.waitForAngularLoad();
       // wa.ajaxComplete();

    }

    public void navigate(String url){
        driver.navigate().to(url);
    }


    protected WebElement findElement(By by) {
        waitAllRequest();

        WebElement el;
        try{
            el = driver.findElement(by);
        }catch(Exception e){
            el = null;
        }
        return el;
    }
    protected void switchWindow() {

        for (String handle : driver.getWindowHandles()) {

            driver.switchTo().window(handle);}
    }


    protected void scrollToElement(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);

    }

    protected void clickElement(By by) {
        findElement(by).click();
    }

    protected void sendKeys(By by, String text) {
        System.out.print("Text entered "+text+" into " +by.toString()+"\n");
        findElement(by).sendKeys(text);

    }


    protected String getText(By by) {
        if(findElement(by) == null)
            return "";
        else
            return findElement(by).getText();
    }

    protected List<WebElement> getElements(By by) {
        waitAllRequest();
        return driver.findElements(by);
    }

    protected boolean isElementExist(By by) {

        WebElement el = findElement(by);
        if (el == null)
            return false;
        else {
            //scrollToElement(el);
            System.out.println("Element " + by.toString() + " is present\n");
            return true;
        }
    }

    public void clear(By by){
        findElement(by).clear();
        System.out.println("Text found in " + by.toString() + " is cleared\n");
    }

}
