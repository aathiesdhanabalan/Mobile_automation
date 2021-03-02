package StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
/*import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;*/
import org.openqa.selenium.WebElement;
import utils.CategoryPage;
import utils.Driver;

import java.net.MalformedURLException;


public class CategorySteps {

    public static AppiumDriver<WebElement> driver;

    CategoryPage cp=new CategoryPage();



    @Given("I am on Blibli app")
    public void iAmOnBlibliApp() throws MalformedURLException
    {
        Driver d=new Driver();
        driver= d.setWebDriver();
    }
    @When("I click categories button")
    public void iClickCategoriesButton() {
        cp.navigate();
    }
    @Then("I choose a categories in the list")
    public void iChooseACategoriesAndProductInTheList() {
        cp.second_navigate();
    }
    @Then("The product description page is opened")
    public void theProductDescriptionPageIsOpened() {
        cp.scrollclick();
    }
    @And("I close the app")
    public void thisIsATest()
    {
        System.out.println("Finished");
    }


}
