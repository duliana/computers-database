package cases.computers;

import cases.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.computers.ComputersPage;
import utils.Browsers;

public class SearchComputerTests extends BaseTest {

    //Add computer and search for it
    @Test
    public void searchComputerOK() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.searchForComputer();
    }

    //Search with empty results
    @Test
    public void searchComputerNoResults() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(COMPUTERS_PAGE);
        computersPage.searchNoResults();
    }
}
