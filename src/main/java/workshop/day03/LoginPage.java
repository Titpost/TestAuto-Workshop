package workshop.day03;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(className = "uui-profile-menu")
    private WebElement uuiProfileMenu;

    @FindBy(className = "btn-login")
    private WebElement btnLogin;

    @FindBy(id = "Login")
    private WebElement loginEdit;

    @FindBy(id = "Password")
    private WebElement passwordEdit;


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
}
