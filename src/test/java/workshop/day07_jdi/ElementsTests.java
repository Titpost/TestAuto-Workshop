package workshop.day07_jdi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day07_jdi.base.JdiTestsBase;

import static workshop.day07_jdi.JdiSite.*;
import static workshop.jdi_common.entities.Users.DEFAULT;
import static workshop.jdi_common.enums.ColorsEnum.Red;
import static workshop.jdi_common.enums.ElementsEnum.FIRE;
import static workshop.jdi_common.enums.ElementsEnum.WATER;
import static workshop.jdi_common.enums.HeaderMenu.METALS$COLORS;
import static workshop.jdi_common.enums.MetalsEnum.Selen;
import static workshop.jdi_common.enums.VegetablesEnum.Cucumber;
import static workshop.jdi_common.enums.VegetablesEnum.Tomato;


public class ElementsTests extends JdiTestsBase {

    @BeforeClass
    public void before() {
        loginPage.shouldBeOpened();

        // DONE create constant on User class for this purpose, cause you should divide data layer and test layer.
        // DONE imagine that you have more than one User...
        // Login on JDI site as User
        header.loginAs(DEFAULT);

        // DONE russian ? really ?
        // DONE this approach might lead us to conflicts with customer/colleagues, i assume you clearly understand that
        // DONE this method will work in case if we trying to open sub-menu...
        // DONE: 'и' -> '$'
        // Open Metals & Colors page by Header menu
        headerMenu.select(METALS$COLORS);
        metalsColorsPage.checkOpened();
    }

    // DONE you should fill this with EntityDriving testing approach
    // This is gonna appear in day08, isn't it?
    @Test
    public void selectRadios() {
        // Summary: 3, 8
        metalsColorsPage.selectRadios("3", "8");
    }

    @Test
    public void selectCheckboxes() {
        // Elements: Water, Fire
        metalsColorsPage.selectCheckboxes(WATER, FIRE);
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
    // !TODO

    @AfterClass
    public void after() {
        // Submit form Metals & Colors
        metalsColorsPage.submit();
        // Result sections should contains data
        metalsColorsPage.checkResults();
    }
}
