package steps;

import com.codeborne.selenide.testng.ScreenShooter;
import common.Context;
import common.PageManager;
import common.ScenarioContext;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Listeners;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
@Listeners({ScreenShooter.class})
public class LoginSteps {

    PageManager pageManager = new PageManager();
    ScenarioContext scenarioContext = new ScenarioContext();


    @Given("Open the web site")
    public void openPage() {
        pageManager.loginPage.open();
    }

    @When("Enter {string} and {string} and click login button")
    public void fillLoginCredentialsAndClickLogin(String username, String password) {
        pageManager.loginPage.login(username,password);
    }

    @Then("Login successfully")
    public void loginSuccessfully() throws InterruptedException {
        assertThat(pageManager.homePage.getUrl()).contains("inventory");
    }

    @Then("Getting error as {string}")
    public void gettingErrorAs(String errorText) {
        assertThat(pageManager.loginPage.lblLoginError.getText()).isEqualTo(errorText);
    }

    @When("Enter user credentials from table")
    public void enterLoginCredentials(DataTable dataTable){
        String username = null;
        String password = null;
        List<Map<String, String>> data =dataTable.asMaps(String.class, String.class);
        for(Map<String, String> form : data){
            username = form.get("username");
            password = form.get("password");
        }
        pageManager.loginPage.login(username,password);
    }

    @When("I set scenario context value {string}")
    public void iSetScenarioContextValue(String value) {
        scenarioContext.setContext(Context.ID, value);
    }
    @Then("I use scenario context value")
    public void iUseScenarioContextValue() {
        String sharedValue = scenarioContext.getContext(Context.ID).toString();
        System.out.println(sharedValue);
    }

    @When("Get data on file and login and Getting error")
    public void getDataOnFileAndLogin() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,String>> userList = mapper.readValue(new FileReader("src/test/resources/datas/user.json"), List.class);
        for (Map<String,String> user: userList) {
            pageManager.loginPage.login(user.get("username"),user.get("password"));
            assertThat(pageManager.loginPage.lblLoginError.isDisplayed()).isTrue();
        }
    }

    @When("User click google account")
    public void userClickGoogleAccount() {

    }

    @Then("Social Media Login page open")
    public void socialMediaLoginPageOpen() {

    }

    @When("User input credentials")
    public void userInputCredentials() {
    }

}
