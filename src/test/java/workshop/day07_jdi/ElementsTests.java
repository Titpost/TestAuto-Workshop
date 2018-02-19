package workshop.day07_jdi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.base.JdiTestsBase;
import workshop.day07_jdi.entities.User;

import static workshop.day07_jdi.JdiSite.*;
import static workshop.day07_jdi.enums.ColorsEnum.Red;
import static workshop.day07_jdi.enums.HeaderMenu.METALSиCOLORS;
import static workshop.day07_jdi.enums.MetalsEnum.Selen;
import static workshop.day07_jdi.enums.VegetablesEnum.Cucumber;
import static workshop.day07_jdi.enums.VegetablesEnum.Tomato;


public class ElementsTests extends JdiTestsBase {

    @BeforeClass
    public void before() {
        loginPage.shouldBeOpened();

        // Login on JDI site as User
        header.loginAs(new User("epam", "1234"));

        // Open Metals & Colors page by Header menu
        headerMenu.select(METALSиCOLORS);
        metalsColorsPage.checkOpened();
    }

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
        metalsColorsPage.submit();
    }
}
