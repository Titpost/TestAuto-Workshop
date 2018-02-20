package workshop.day08_jdi;

import org.testng.annotations.BeforeClass;
import workshop.base.JdiTestsBase;
import workshop.jdi_common.entities.User;

import static workshop.day08_jdi.JdiSite.header;
import static workshop.day08_jdi.JdiSite.headerMenu;
import static workshop.day08_jdi.JdiSite.loginPage;
import static workshop.jdi_common.enums.HeaderMenu.METALS$COLORS;


public class ElementsTests extends JdiTestsBase {

    @BeforeClass
    public void before() {
        loginPage.shouldBeOpened();

        // Login on JDI site as User
        header.loginAs(new User("epam", "1234"));

        // Open Metals & Colors page by Header menu
        headerMenu.select(METALS$COLORS);
//        metalsColorsPage.checkOpened();
    }
/*
    @Test
    public void selectRadios() {
        // Summary: 3, 8
        metalsColorsPage.selectRadios("3", "8");
    }

    @Test
    public void selectCheckboxes() {
        // Elements: Water, Fire
        metalsColorsPage.selectCheckboxes("Water", "Fire");
    }

    @Test
    public void selectColor() {
        // Colors: Red
        metalsColorsPage.selectColor(Red);
    }

    @Test
    public void selectMetal() {
        // Metals: Selen
        metalsColorsPage.selectMetal(Selen);
    }

    @Test
    public void selectVegetables() {
        // Vegetables: Cucumber,Tomato
        metalsColorsPage.selectVegetables(Cucumber, Tomato);
    }

    @AfterClass
    public void after() {
        // Submit form Metals & Colors
        metalsColorsPage.submit();
        // Result sections should contains data
        metalsColorsPage.checkResults();
    }*/
}
