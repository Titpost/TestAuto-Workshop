package workshop.day04;

import com.codeborne.selenide.Configuration;
import enums.LoginPageIconsTextsEnum;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

/**
 * Page object for Selenide tests.
 */
public class SelenidePage {

    /**
     * Factory method.
     *
     * @return new instance
     */
    public static SelenidePage getInstance() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "CHROME";

        return new SelenidePage();
    }

    /**
     * Opens page by URL.
     *
     * @param pageUrl to be opened
     */
    public void openPage(String pageUrl) {
        open(pageUrl);
    }

    /**
     * Authentication procedure.
     *
     * @param name - user
     * @param pass - password
     */
    public void login(String name, String pass) {

        $(".uui-profile-menu").click();
        $("#Login").sendKeys(name);
        $("#Password").sendKeys(pass);
        $(".fa-sign-in").click();
    }

    /**
     * Checks if authentication was successful (user name is presents).
     *
     * @param name of user to be displayed
     */
    public void checkProfileName(String name) {
        $(".profile-photo span").shouldHave(text(name));
    }

    /**
     * Checks if the icon is present and the text beneath is correct.
     */
    public void checkIconsWithTexts(LoginPageIconsTextsEnum[] benefits) {

        assertEquals(text, $$(".benefit").stream()
                .filter(b -> b.$(icon) != null)
                .findAny().get().$(".benefit-txt").getText().replaceAll("\\r\\n|\\r|\\n", " ")
        );
    }
}
