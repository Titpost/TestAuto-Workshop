package workshop.day04_05;

import enums.loginPage.LoginPageIconsTextsEnum;
import enums.loginPage.SubMenuServicesEnum;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import workshop.day04_05.base.BaseSelenideTest;
import workshop.day04_05.listeners.AllureAttachmentListener;
import workshop.day04_05.pageObjects.DifferentElementsPage;

@Listeners(AllureAttachmentListener.class)
@Features({"Allure Reports Suite"})
@Stories({"Sliders tests"})
public class MenuAndElements extends BaseSelenideTest {

    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
    }

    @AfterClass
    public void closeDown() {
        super.closeDown();
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
