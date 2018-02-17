package workshop.day07_jdi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import workshop.JdiTestsBase;
import workshop.day07_jdi.entities.User;

import java.io.IOException;
import java.lang.reflect.Method;

import static workshop.day07_jdi.JdiSite.*;
import static workshop.day07_jdi.enums.HeaderMenu.METALSиCOLORS;


public class ElementsTests extends JdiTestsBase {

    @BeforeMethod
    public void before(Method method) throws IOException {
        loginPage.shouldBeOpened();
        loginPage.header.loginAs(new User("epam", "1234"));
    }

    @Test
    public void fillElements() {
        headerMenu.select(METALSиCOLORS);
        metalsColorsPage.checkOpened();
    }
}
