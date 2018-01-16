package workshop.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /**
     * Class Factory.
     * @param driver - Selenium WebDriver
     * @return Page Object
     */
    public static LoginPage getInstance(WebDriver driver) {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @FindBy(className = "uui-profile-menu")
    private WebElement uuiProfileMenu;

    @FindBy(className = "btn-login")
    private WebElement btnLogin;

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "Login")
    private WebElement loginEdit;

    @FindBy(id = "Password")
    private WebElement passwordEdit;

    private WebDriver driver;

    LoginPage() {}
    LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Performs authentication.
     * @param name - user name
     * @param password - user password
     */
    void login(String name, String password) {

        // expand login sub-form
        uuiProfileMenu.click();

        // fill name and password
        loginEdit.sendKeys(name);
        passwordEdit.sendKeys(password);

        // submit
        btnLogin.click();
    }

    void assertTextByClass(String text, String className) {

    }

    void assertTextByTag(String text, String tagName) {

    }


}
