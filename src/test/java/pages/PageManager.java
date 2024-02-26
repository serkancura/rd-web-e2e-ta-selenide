package pages;

import driver.DriverFactory;

public class PageManager {
    public LoginPage loginPage;

    public PageManager() {

        DriverFactory.initDriver();

        loginPage = PageFactory.buildLoginPage() ;
    }
}
