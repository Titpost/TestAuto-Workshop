package workshop.day08_jdi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day08_jdi.base.JdiTestsBase;
import workshop.day08_jdi.dataprovider.Pojo;
import workshop.day08_jdi.dataprovider.PojoReader;

import java.util.List;

import static workshop.day08_jdi.JdiSite.*;
import static workshop.day08_jdi.dataprovider.PojoReader.readData;
import static workshop.jdi_common.entities.Users.DEFAULT;
import static workshop.jdi_common.enums.ColorsEnum.Red;
import static workshop.jdi_common.enums.DigitsEnum.EIGHT;
import static workshop.jdi_common.enums.DigitsEnum.THREE;
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

        // Login on JDI site as User
        header.loginAs(DEFAULT);

        // Open Metals & Colors page by Header menu
        headerMenu.select(METALS$COLORS);
        metalsColorsPage.checkOpened();
    }


    @Test public void go() {
        List<Pojo> pogos = PojoReader.readWithGson(readData());
        return;
    }

    @Test
    public void selectSummary() {
        // Summary: 3, 8
        metalsColorsPage.selectSummary(THREE, EIGHT);
    }

    @Test
    public void selectElements() {
        // Elements: Water, Fire
        metalsColorsPage.selectElements(WATER, FIRE);
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
        metalsColorsPage.selectNewVegetables(Cucumber, Tomato);
    }

    @AfterClass
    public void after() {
        // Submit form Metals & Colors
        metalsColorsPage.submit();
        // Result sections should contains data
        metalsColorsPage.checkResults();
    }
}
