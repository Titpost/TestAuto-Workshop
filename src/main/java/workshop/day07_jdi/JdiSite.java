package workshop.day07_jdi;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;
import workshop.day07_jdi.enums.HeaderMenu;
import workshop.day07_jdi.pages.LoginPage;
import workshop.day07_jdi.pages.MetalsColors;
import workshop.day07_jdi.sections.Header;


@JSite("https://epam.github.io/JDI")
public class JdiSite extends WebSite {

    @JPage(url = "/index.html")
    public static LoginPage loginPage;

    @JPage("/metals-colors.html")
    public static MetalsColors metalsColorsPage;

    @FindBy(css = ".m-l8")
    public static Menu<HeaderMenu> headerMenu;


    public static Header header;
}
