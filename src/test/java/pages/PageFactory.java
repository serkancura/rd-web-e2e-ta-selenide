package pages;

public class PageFactory {

    public static LoginPage buildLoginPage() {
        return new LoginPage("/");
    }

}
