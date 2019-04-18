package pages.computers;

import org.apache.commons.lang3.RandomStringUtils;
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
        clickElement(submit);

        //Verify the name is required
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'Required')]")), "Empty name");
        String newName = computer.getName();
        sendKeys(computerName, newName);

        //Verify the introduced date with the wrong format
        sendKeys(introduced, "2000/01/13");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of Introduced Date");

        //Verify the introduced date with the right format but swap Month and Date
        clear(introduced);
        sendKeys(introduced, "2000-13-01");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format MM-dd of Introduced Date");

        //Verify the introduced date with text
        clear(introduced);
        sendKeys(introduced, "test");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Introduced Date contains text");

        //Verify the discontinued date with the wrong format
        clear(introduced);
        sendKeys(introduced, "2000-01-01");
        sendKeys(discontinued, "2000/01/01");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of Discontinued Date");

        //Verify the discontinued date with the right format but swap Month and Date
        clear(discontinued);
        sendKeys(discontinued, "2000-13-01");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of MM-dd of Discontinued Date");

        //Verify the discontinued date with text
        clear(discontinued);
        sendKeys(discontinued, "test");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Discontinued Date contains text");

        soft.assertAll();

    }

    //SEARCH COMPUTER

    //Add computer and find it with Search
    public void searchForComputer() {
        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        Select dropdown = new Select(driver.findElement(company));
        dropdown.selectByVisibleText("Apple Inc.");
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));
    }

    //Search for computer name that doesn't exist
    public void searchNoResults() {
        sendKeys(searchField, RandomStringUtils.randomAlphanumeric(20));
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//div[@class='well']//em[text()='Nothing to display']")));
    }


    //EDIT COMPUTER

    //Add computer, find it and Edit the values
    public void editComputerSuccessfully() {
        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        Select dropdown = new Select(driver.findElement(company));
        dropdown.selectByVisibleText("Canon");
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

    //Edit computer with all fields and remove optional
    public void editComputerWithAllFields() {
        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        Select dropdown = new Select(driver.findElement(company));
        dropdown.selectByVisibleText("Sony");
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));

        //Edit computer
        clickElement(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']"));
        clear(introduced);
        clear(discontinued);
        clickElement(submit);
        Assert.assertTrue(isElementExist(By.xpath(DONE)));
    }

    //Verify computer cannot be edited with not valid data
    public void editComputerValidations() {
        //Add computer
        String newName = computer.getName();
        fillForm(newName,computer.getIntroduced(),computer.getDisocntinued());
        Select dropdown = new Select(driver.findElement(company));
        dropdown.selectByVisibleText("Netronics");
        clickElement(submit);

        //Search for the name
        sendKeys(searchField, newName);
        clickElement(searchButton);
        Assert.assertTrue(isElementExist(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']")));

        //Edit computer
        clickElement(By.xpath("//table[@class='computers zebra-striped']//tbody//tr//td/a[text()='"+newName+"']"));

        SoftAssert soft = new SoftAssert();

        //Verify the name is required
        clear(computerName);
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'Required')]")), "Empty name");

        //Verify the introduced date with the wrong format
        sendKeys(computerName, newName);
        clear(introduced);
        sendKeys(introduced, "02/12/2012");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of Introduced Date");

        //Verify the introduced date with the right format but swap Month and Date
        clear(introduced);
        sendKeys(introduced, "2000-13-01");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of Introduced Date");

        //Verify the introduced date with text
        clear(introduced);
        sendKeys(introduced, "test!");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Introduced Date contains text");

        //Verify the discontinued date with the wrong format
        clear(introduced);
        sendKeys(introduced, "2000-01-01");
        clear(discontinued);
        sendKeys(discontinued, "1990.12.12");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of Discontinued Date");

        //Verify the discontinued date with the right format but swap Month and Date
        clear(discontinued);
        sendKeys(discontinued, "2000-13-01");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Wrong format of MM-dd of Discontinued Date");

        //Verify the discontinued date with text
        clear(discontinued);
        sendKeys(discontinued, "test2");
        clickElement(submit);
        soft.assertTrue(isElementExist(By.xpath("//span[contains(.,'yyyy-MM-dd')]")), "Discontinued Date contains text");

        soft.assertAll();
    }


    //DELETE COMPUTER

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
