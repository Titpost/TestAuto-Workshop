package workshop.day08_jdi;

import org.testng.annotations.*;
import workshop.day08_jdi.base.JdiTestsBase;
import workshop.day08_jdi.dataprovider.Pojo;

import static workshop.day08_jdi.JdiSite.*;
import static workshop.day08_jdi.dataprovider.PojoReader.readFromResource;
import static workshop.day08_jdi.dataprovider.PojoReader.readWithGson;
import static workshop.jdi_common.entities.Users.DEFAULT;
import static workshop.jdi_common.enums.HeaderMenu.HOME;
import static workshop.jdi_common.enums.HeaderMenu.METALS$COLORS;


public class ElementsTests extends JdiTestsBase {

    @BeforeClass
    public void before() {
        loginPage.shouldBeOpened();

        // Login on JDI site as User
        header.loginAs(DEFAULT);
    }

    @BeforeMethod
    public void gotoPage() {
        // Open Metals & Colors page by Header menu
        headerMenu.select(METALS$COLORS);
        metalsColorsPage.checkOpened();
    }

    @AfterMethod
    public void leavePage() {
        headerMenu.select(HOME);
    }

    @DataProvider
    public static Object[] data() {
        return readWithGson(readFromResource()).toArray();
    }

    @Test(dataProvider = "data")
    public void go(Pojo pogo) {

        // Summary: 3, 8
        metalsColorsPage.selectSummary(pogo.summary);

        // Elements: Water, Fire
        metalsColorsPage.selectElements(pogo.elements);

        // Colors: Red
        metalsColorsPage.selectColor(pogo.color);

        // Metals: Selen
        metalsColorsPage.selectMetal(pogo.metals);

        // Vegetables: Cucumber,Tomato
        metalsColorsPage.selectNewVegetables(pogo.vegetables);

        // Submit form Metals & Colors
        metalsColorsPage.submit();

        // Result sections should contains data
        metalsColorsPage.checkResults(pogo);
    }
}
