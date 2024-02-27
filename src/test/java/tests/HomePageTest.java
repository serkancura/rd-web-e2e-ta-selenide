package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest{

    @BeforeMethod
    public void before(){
        pageManager.loginPage.open();
        pageManager.loginPage.login("standard_user","secret_sauce");
    }

    @Test
    public void addProductToCart(){
        pageManager.homePage.btnAddCartSauceLabsBackpack.click();;
        assertThat(pageManager.homePage.btnRemoveCartSauceLabsBackpack.isDisplayed()).isTrue();
    }
}
