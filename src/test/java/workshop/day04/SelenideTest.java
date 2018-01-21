package workshop.day04;

import enums.loginPage.LoginPageIconsTextsEnum;
import enums.loginPage.SubMenuServicesEnum;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day04.pageObjects.DifferentElementsPage;
import workshop.day04.pageObjects.LoginPage;

public class SelenideTest {

    private LoginPage loginPage;

    /**
     * Gets Object-Page instance.
     */
    @BeforeClass
    public void setUp() {
        loginPage = LoginPage.getInstance("https://jdi-framework.github.io/tests");
    }

    /**
     * Pages main test.
     */
    @Test
    public void login() {

        loginPage.login("epam", "1234");

        loginPage.checkProfileName("Piter Chailovskii");

        loginPage.checkIconsWithTexts(LoginPageIconsTextsEnum.values());

        loginPage.checkMainTitle("EPAM FRAMEWORK WISHES…");

        loginPage.checkMainText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR "
                + "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION "
                + "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT "
                + "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        loginPage.checkHeaderSubMenuItemsExist(SubMenuServicesEnum.values());

        loginPage.checkLeftSectionItemsExist(SubMenuServicesEnum.values());

        final DifferentElementsPage differentElementsPage = loginPage.gotoDifferentElementsPage();

        differentElementsPage.checkElements();

        differentElementsPage.checkCheckboxSelection();
    }
}
