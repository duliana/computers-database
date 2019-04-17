package cases.computers;

import cases.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.computers.ComputersPage;
import utils.Browsers;

public class DeleteComputerTests extends BaseTest{

    @Test
    public void deleteComputerOK() {

        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.deleteComputerSuccessfully();

    }
}
