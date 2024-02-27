package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest  extends BaseTest{

    @Test
    public void loginTest(){
        pageManager.loginPage.open();
        pageManager.loginPage.login("standard_user","secret_sauce");
        assertThat(pageManager.homePage.spnHompageTitle.isDisplayed()).isTrue();
    }

    @Test
    public void loginFailTest(){
        pageManager.loginPage.open();
        pageManager.loginPage.login("standard_userr","secret_sauce");
        assertThat(pageManager.loginPage.getLoginError()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }
}
