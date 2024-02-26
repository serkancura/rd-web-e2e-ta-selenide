package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.PageManager;
import tests.BaseTest;

public class LoginSteps extends BaseTest {

    PageManager pageManager = new PageManager();
    SoftAssert softAssert= new SoftAssert();


    @Given("^Open the web site$")
    public void openPage() {
        pageManager.loginPage.open();
    }

    @When("Enter {string} and {string} and click login button")
    public void fillLoginCredentialsAndClickLogin(String username, String password) {
        pageManager.loginPage.login(username,password);
    }

    @Then("Login successfully")
    public void loginSuccessfully() {
        softAssert.assertTrue(pageManager.loginPage.getUrl().contains("inventory"));
    }

    @Then("Getting error as {string}")
    public void gettingErrorAs(String errorText) {
        softAssert.assertEquals(pageManager.loginPage.getLoginError(),errorText);
    }
}
