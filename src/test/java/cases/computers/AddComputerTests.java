package cases.computers;

import cases.BaseTest;
import org.testng.annotations.Test;
import utils.Browsers;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.computers.ComputersPage;

public class AddComputerTests extends BaseTest{

    //Add computer with all fields
    @Test
    public void addNewComputerOK() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.addNewComputerSuccessfully();
    }

    //Add computer with only name
    @Test
    public void addNewComputerOnlyNameOK() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.addNewComputerOnlyName();
    }
}
