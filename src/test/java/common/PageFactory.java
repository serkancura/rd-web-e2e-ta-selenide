package common;

import org.apache.log4j.Logger;
import pages.HomePage;
import pages.LoginPage;

public class PageFactory {
    static final Logger logger = Logger.getLogger(PageFactory.class);

    public static LoginPage buildLoginPage() {
        return new LoginPage("/");
    }

    public static HomePage buildHomePage() {
        return new HomePage("/inventory.html");
    }

}
