package cases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import utils.Browsers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.TestLogger;
import utils.ExtentManager;


public class BaseTest implements ITest {
    public static WebDriver driver;
    public static String ADD_COMPUTER_PAGE = "http://computer-database.herokuapp.com/computers/new";
    public static String COMPUTERS_PAGE = "http://computer-database.herokuapp.com/computers";
    public static TestLogger logger = TestLogger.getInstance();
    protected static ExtentReports extent;
    private static String testName = "";

    @Override
    public String getTestName() {
        return testName;
    }

    @BeforeMethod(alwaysRun = true)
    public static void setup(){
        Browsers.setDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void AfterMethod(){
        driver = Browsers.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){

        extent = ExtentManager.getInstance();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public static void AfterSuite(){
        extent.flush();

    }

}
