package tests;

import org.testng.annotations.Test;

public class LoginTest  extends BaseTest{

    @Test
    public void loginTest(){
        pageManager.loginPage.open();
        pageManager.loginPage.login("standard_user","secret_sauce");
        softAssert.assertTrue(pageManager.loginPage.getUrl().contains("inventory"));
    }

    @Test
    public void loginFailTest(){
        pageManager.loginPage.open();
        pageManager.loginPage.login("standard_userr","secret_sauce");
        softAssert.assertEquals(pageManager.loginPage.getLoginError(),"Epic sadface: Username and password do not match any user in this service");
    }
}
