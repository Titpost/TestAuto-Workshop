package workshop.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    /**
     * Class Factory.
     *
     * @param driver - Selenium WebDriver
     * @return Page Object
     */
    public static LoginPage getInstance(WebDriver driver) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.driver = driver;
        return loginPage;
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


    /**
     * Performs authentication.
     *
     * @param name     - user name
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

    void checkLoggedAs(String name) {
        final WebElement element = profilePhoto.findElement(By.tagName("span"));
        Assert.assertEquals(name, element.getText());
    }

    void assertTextByClass(String text, String className) {

    }

    void assertTextByTag(String text, String tagName) {

    }


}
