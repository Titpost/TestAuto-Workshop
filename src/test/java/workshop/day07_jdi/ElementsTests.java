package workshop.day07_jdi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.base.JdiTestsBase;
import workshop.jdi_common.entities.User;

import static workshop.day07_jdi.JdiSite.*;
import static workshop.jdi_common.enums.ColorsEnum.Red;
import static workshop.jdi_common.enums.HeaderMenu.METALSиCOLORS;
import static workshop.jdi_common.enums.MetalsEnum.Selen;
import static workshop.jdi_common.enums.VegetablesEnum.Cucumber;
import static workshop.jdi_common.enums.VegetablesEnum.Tomato;


public class ElementsTests extends JdiTestsBase {

    @BeforeClass
    public void before() {
        loginPage.shouldBeOpened();

        // TODO create constant on User class for this purpose, cause you should divide data layer and test layer.
        // TODO imagine that you have more than one User...
        // Login on JDI site as User
        header.loginAs(new User("epam", "1234"));

        // TODO russian ? really ?
        // TODO this approach might lead us to conflicts with customer/colleagues, i assume you clearly understand that
        // TODO this method will work in case if we trying to open sub-menu...
        // Open Metals & Colors page by Header menu
        headerMenu.select(METALSиCOLORS);
        metalsColorsPage.checkOpened();
    }

    // TODO you should fill this with EntityDriving testing approach
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
    // !TODO

    @AfterClass
    public void after() {
        // Submit form Metals & Colors
        metalsColorsPage.submit();
        // Result sections should contains data
        metalsColorsPage.checkResults();
    }
}
