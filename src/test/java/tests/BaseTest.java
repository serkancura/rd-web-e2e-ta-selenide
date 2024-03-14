package tests;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import common.PageManager;
import driver.DriverFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners({ScreenShooter.class})
public class BaseTest {
    static final Logger logger = Logger.getLogger(BaseTest.class);
    protected PageManager pageManager;

    @BeforeSuite
    public void setUp() {
        logger.info("Testler Balşıyor....");
        pageManager = new PageManager();
        ScreenShooter.captureSuccessfulTests = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @BeforeMethod
    public void openDriver() {
        logger.info("Browser açılıyor.");
        Selenide.open();
    }

    @AfterClass
    public void clearCookies() throws IOException {
        logger.info("Cookieler temizleniyor ve Browser kapatılıyor...");
        DriverFactory.clearCookies();

        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.close();
    }
}
