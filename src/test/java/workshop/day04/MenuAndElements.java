package workshop.day04;

import enums.loginPage.LoginPageIconsTextsEnum;
import enums.loginPage.SubMenuServicesEnum;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day04.pageObjects.BasePage;
import workshop.day04.pageObjects.DifferentElementsPage;
import workshop.day04.pageObjects.LoginPage;

public class MenuAndElements extends BasePage {

    private LoginPage loginPage;
    private DifferentElementsPage differentElementsPage;

    /**
     * Gets Object-Page instance.
     */
    @BeforeClass
    public void setUp() {
        // Open test site by URL
        loginPage = LoginPage.getInstance("https://jdi-framework.github.io/tests");

        // Perform login
        loginPage.login("epam", "1234");

        // Assert User name in the left-top side of screen that user is loggined
        loginPage.checkProfileName("Piter Chailovskii");
    }

    /**
     * Login and Different Elements page test
     */
    @Test
    public void loginAndElementsPage() {

        // Check interface on Home page, it contains all needed elements.
        loginPage.checkIconsWithTexts(LoginPageIconsTextsEnum.values());

        loginPage.checkMainTitle("EPAM FRAMEWORK WISHES…");

        loginPage.checkMainText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR "
                + "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION "
                + "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT "
                + "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // Click on "Service" subcategory in the header and check that drop down contains options
        loginPage.checkHeaderSubMenuItemsExist(SubMenuServicesEnum.values());

        // Click on Service subcategory in the left section and check that drop down contains options
        loginPage.checkLeftSectionItemsExist(SubMenuServicesEnum.values());

        // Open through the header menu Service -> Different Elements Page
        loginPage.gotoDifferentElementsPage();
        differentElementsPage = DifferentElementsPage.getInstance();

        // Check interface on Service page, it contains all needed elements.
        differentElementsPage.checkElements();

        // Select and assert checkboxes
        differentElementsPage.checkCheckboxSelection();

        // Select radio
        differentElementsPage.checkRadioSelection();

        // Select in dropdown
        differentElementsPage.checkDropdownSelection();

        // Check in logs section selected values and status (true|false)
        differentElementsPage.checkLogs();

        // Unselect and assert checkboxes
        // Check in logs section unselected values and status (true|false)
        differentElementsPage.checkUnselection();
    }

}
