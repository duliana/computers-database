package cases;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.Browsers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static WebDriver driver;
    public static String COMPUTERS_PAGE = "/computers";
    public static String ADD_COMPUTER_PAGE = "http://computer-database.herokuapp.com/computers/new";

    protected String URL = "http://computer-database.herokuapp.com";

    @BeforeMethod(alwaysRun = true)
    public static void setup(){
        driver = Browsers.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterMethod(){
        driver = Browsers.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

  /*  @BeforeClass
    public static void setup(){
        driver = Browsers.getDriver();
    }


    @AfterClass
    public static void trash(){
        driver.close();
        driver.quit();
    }*/
}
