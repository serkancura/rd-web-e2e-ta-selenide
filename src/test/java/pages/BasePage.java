package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import utils.PropertyManager;

public abstract class BasePage {
    static final Logger logger = Logger.getLogger(BasePage.class);
    protected String pageUrl;
    PropertyManager propertyManager = new PropertyManager();

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        String url = propertyManager.getProperty("APP_URL") ;
        Selenide.open(url);

    }

    public String getUrl() throws InterruptedException {
        //Thread.sleep(2000);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
