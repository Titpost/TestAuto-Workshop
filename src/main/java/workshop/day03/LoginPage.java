package workshop.day03;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @FindBy(className = "main-title")
    private WebElement mainTitle;

    @FindBy(className = "main-txt")
    private WebElement mainText;

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "Login")
    private WebElement loginEdit;

    @FindBy(id = "Password")
    private WebElement passwordEdit;


    /**
     * Opens the page for object.
     *
     * @param url of the page
     */
    public void openPage(String url) {
        driver.navigate().to(url);
    }

    /**
     * Closes browser.
     */
    public void close() {
        driver.close();
    }


    /**
     * Performs authentication.
     *
     * @param name     - user name
     * @param password - user password
     */
    public void login(String name, String password) {

        // expand login sub-form
        uuiProfileMenu.click();

        // fill name and password
        loginEdit.sendKeys(name);
        passwordEdit.sendKeys(password);

        // submit
        btnLogin.click();
    }

    /**
     * Checks for user name to be displayed when logged in.
     *
     * @param name of logged user
     */
    public void checkLoggedAs(String name) {
        final WebElement element = profilePhoto.findElement(By.tagName("span"));
        assertEquals(name, element.getText());
    }

    /**
     * Asserts page title
     *
     * @param text for title.
     */
    public void assertTitleEquals(String text) {
        assertEquals(driver.getTitle(), text);
    }

    /**
     * Checks if icons are shown.
     */
    public void checkImagesAreDisplayed(String className) {
        final List<WebElement> benefitImages = driver.findElements(By.className(className));
        for (WebElement img : benefitImages) {
            assertTrue(img.isDisplayed());
        }
    }

    /**
     * Checks the texts below the icons.
     *
     * @param texts array
     */
    public void checkTextsUnderImages(String className, IndexPageTextsEnum[] texts) {
        final List<WebElement> benefitTexts = driver.findElements(By.className(className));
        for (byte i = 0; i < texts.length; i++) {
            assertEquals(texts[i].text,
                    benefitTexts.get(i).getText().replaceAll("\\r\\n|\\r|\\n", " "));
        }
    }

    /**
     * Checks main page title.
     *
     * @param title text
     */
    public void checkMainTitle(String title) {
        assertEquals(mainTitle.getText(), title);
    }

    /**
     * Checks main text
     * @param text to check
     */
    public void checkMainText(String text) {
        assertEquals(mainText.getText(), text);
    }
}
