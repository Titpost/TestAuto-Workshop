package workshop.day04.base;

import workshop.day04.pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class BaseSelenideTest {

    protected LoginPage loginPage;

    /**
     * Gets Object-Page instance.
     */
    protected void setUp() {
        // Open test site by URL
        loginPage = LoginPage.getInstance("https://jdi-framework.github.io/tests");

        // Perform login
        loginPage.login("epam", "1234");

        // Assert User name in the left-top side of screen that user is loggined
        loginPage.checkProfileName("Piter Chailovskii");
    }

    /**
     * Closes session
     */
    public void closeDown() {
        close();
    }

}
