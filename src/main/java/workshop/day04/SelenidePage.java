package workshop.day04;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import enums.LoginPageIconsTextsEnum;
import enums.SubMenuServices;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static enums.SubMenuServices.SERVICE_DIFFERENTELEMENTS;
import static org.testng.Assert.assertEquals;

/**
 * Page object for Selenide tests.
 */
public class SelenidePage {

    final private SelenideElement elementDropdown;

    /**
     * Factory method. Opens page by URL.
     *
     * @param pageUrl to be opened
     * @return new instance
     */
    public static SelenidePage getInstance(String pageUrl) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "CHROME";

        open(pageUrl);
        SelenidePage page = new SelenidePage();

        return page;
    }

    private SelenidePage() {
        elementDropdown = $(".dropdown");
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
        for (LoginPageIconsTextsEnum i : benefits) {

            assertEquals(i.text, $$(".benefit").stream()
                    .filter(b -> b.$(i.icon).exists())
                    .findFirst().get().$(".benefit-txt").getText().replaceAll("\\r\\n|\\r|\\n", " ")
            );
        }
    }

    /**
     * Checks main page title.
     *
     * @param title text
     */
    public void checkMainTitle(String title) {
        assertEquals($(".main-title").getText(), title);
    }

    /**
     * Checks main text
     *
     * @param text to check
     */
    public void checkMainText(String text) {
        assertEquals($(".main-txt").getText(), text);
    }

    /**
     * Checks if Service-menu items are present.
     *
     * @param subItems to be contained
     */
    public void checkHeaderSubMenuItemsExist(SubMenuServices[] subItems) {
        expandServicesMenu();
        iterateToAssertPresence(elementDropdown.$(".dropdown-menu"), subItems);
    }

    /**
     * Checks if Left-section items are present.
     *
     * @param subItems to be contained
     */
    public void checkLeftSectionItemsExist(SubMenuServices[] subItems) {
        final SelenideElement elementMenu = $(".sub-menu");
        elementMenu.click();
        iterateToAssertPresence(elementMenu.$(".sub"), subItems);
    }

    /**
     * Clicks menu item - SERVICE_DIFFERENTELEMENTS.
     */
    public void checkDifferentElementsPage() {
        expandServicesMenu();
        elementDropdown.$(".dropdown-menu").$$("li").stream()
                .map(li -> li.$("a"))
                .filter(a -> a.getText().contains(SERVICE_DIFFERENTELEMENTS.text.toUpperCase()))
                .findFirst().get().click();
    }

    /**
     * Asserts all the texts present in element.
     *
     * @param container - element to look for texts in
     * @param subItems  - texts to find for
     */
    private void iterateToAssertPresence(SelenideElement container, SubMenuServices[] subItems) {
        for (SubMenuServices item : subItems) {
            container.shouldHave(text(item.text));
        }
    }

    /**
     * Clicks on menu dropdown-toggle to expand
     */
    private void expandServicesMenu() {
        elementDropdown.$(".dropdown-toggle").click();
    }
}
