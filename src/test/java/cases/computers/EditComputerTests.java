package cases.computers;

import cases.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.computers.ComputersPage;
import utils.Browsers;

public class EditComputerTests extends BaseTest {

    //Edit all fields
    @Test
    public void editComputerOK() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.editComputerSuccessfully();
    }

    //Remove optional fields
    @Test
    public void editComputerRemoveOptional() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.editComputerWithAllFields();
    }

    //Remove optional fields
    @Test
    public void editComputerValidations() {
        WebDriver driver = Browsers.getDriver();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.navigate(ADD_COMPUTER_PAGE);
        computersPage.editComputerValidations();
    }

}
