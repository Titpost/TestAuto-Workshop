package workshop.day07_jdi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import workshop.base.JdiTestsBase;
import workshop.day07_jdi.entities.User;

import java.lang.reflect.Method;

import static workshop.day07_jdi.JdiSite.*;
import static workshop.day07_jdi.enums.HeaderMenu.METALSиCOLORS;


public class ElementsTests extends JdiTestsBase {

    @BeforeMethod
    public void before(Method method) {
        loginPage.shouldBeOpened();

        // Login on JDI site as User
        header.loginAs(new User("epam", "1234"));
    }

    @Test
    public void fillElements() {

        // Open Metals & Colors page by Header menu
        headerMenu.select(METALSиCOLORS);
        metalsColorsPage.checkOpened();

        // Summary: 3, 8
        metalsColorsPage.selectRadios("3", "8");
    }
}
