package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.Computer;
import utils.WaitingActions;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WaitingActions wa;
    public static Computer computer = new Computer();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,15);
        this.wa = new WaitingActions(this.driver);
    }

    protected void waitAllRequest(){
        wa.pageLoadComplete();
        wa.jQueryComplete();
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

    protected void clickElement(By by) {
        findElement(by).click();
    }

    protected void sendKeys(By by, String text) {
        System.out.print("Text entered "+text+" into " +by.toString()+"\n");
        findElement(by).sendKeys(text);

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
