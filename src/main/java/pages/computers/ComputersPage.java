package pages.computers;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ComputersPage extends BasePage {

    public ComputersPage(WebDriver driver)  {
        super(driver);
    }

    By computerName = By.id("name");
    By introduced = By.id("introduced");
    By discontinued = By.id("discontinued");
    By company = By.id("company");
    By submit = By.xpath("//div[@class='actions']//input[@type='submit']");
    By searchField = By.id("searchbox");
    By searchButton = By.id("searchsubmit");
    public static String DONE = "//body//div[@class='alert-message warning']//strong[text()='Done!']";
    By delete = By.xpath("//form[@class='topRight']//input[@type='submit']");


    //ADD COMPUTER

    //Add computer with all fields
    public void addNewComputerSuccessfully() {

        fillForm(computer.getName(),computer.getIntroduced(),computer.getDisocntinued());
        Select dropdown = new Select(driver.findElement(company));
        dropdown.selectByVisibleText("Canon");
        clickElement(submit);
        Assert.assertTrue(isElementExist(By.xpath(DONE)));
    }

    //Add computer with only name
    public void addNewComputerOnlyName() {
        String newName = computer.getName();
        sendKeys(computerName, newName);
        clickElement(submit);
        Assert.assertTrue(isElementExist(By.xpath(DONE)));
    }

    //Add computer validations
    public void addNewComputerValidations() {
        SoftAssert soft = new SoftAssert();

    }

    //Add computer and find it with Search
    public void searchForComputer() {

        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));

    }

    //Add computer, find it and Edit the values
    public void editComputerSuccessfully() {

        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));

        //Edit computer
        clickElement(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']"));
        String editName = "Edited computer";
        String editIntroducedDate = "2010-01-01";
        String editDiscontinuedDate = "2019-02-20";
        clear(computerName);
        clear(introduced);
        clear(discontinued);
        fillForm(editName,editIntroducedDate,editDiscontinuedDate);
        clickElement(submit);
        Assert.assertTrue(isElementExist(By.xpath(DONE)));
    }

    //Add computer, find it and Delete it
    public void deleteComputerSuccessfully() {

        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));

        //Delete computer
        clickElement(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']"));
        clickElement(delete);
        Assert.assertTrue(isElementExist(By.xpath(DONE)));
    }

    private void fillForm(String name, String introducedDate, String discontinuedDate){

        sendKeys(computerName, name);
        sendKeys(introduced, introducedDate);
        sendKeys(discontinued, discontinuedDate);
    }
}
