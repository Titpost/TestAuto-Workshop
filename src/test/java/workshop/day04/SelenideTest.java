package workshop.day04;

import enums.LoginPageIconsTextsEnum;
import enums.SubMenuServices;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTest {

    private SelenidePage selenidePage;

    /**
     * Gets Object-Page instance.
     */
    @BeforeClass
    public void setUp() {
        selenidePage = SelenidePage.getInstance();
    }

    @Test
    public void login() {
        selenidePage.openPage("https://jdi-framework.github.io/tests");

        selenidePage.login("epam", "1234");

        selenidePage.checkProfileName("Piter Chailovskii");

        selenidePage.checkIconsWithTexts(LoginPageIconsTextsEnum.values());

        selenidePage.checkMainTitle("EPAM FRAMEWORK WISHES…");

        selenidePage.checkMainText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        selenidePage.checkSubMenuItemsExist(SubMenuServices.values());
    }
}
