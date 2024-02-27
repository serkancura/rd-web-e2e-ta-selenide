package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    public SelenideElement spnHompageTitle = $(".title");
    public SelenideElement btnAddCartSauceLabsBackpack = $("button[data-test=\"add-to-cart-sauce-labs-backpack\"]");
    public SelenideElement btnRemoveCartSauceLabsBackpack = $("button[data-test=\"remove-sauce-labs-backpack\"]");


    public HomePage(String pageUrl) {
        super(pageUrl);
    }






}
