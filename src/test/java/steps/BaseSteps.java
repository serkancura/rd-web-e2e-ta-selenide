package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class BaseSteps {
    @After
    @Attachment
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) // scenario failed take screenshot to allure report
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) DriverFactory.currentDriver()).getScreenshotAs(OutputType.BYTES)));
        System.out.println("Closed");
    }
}
