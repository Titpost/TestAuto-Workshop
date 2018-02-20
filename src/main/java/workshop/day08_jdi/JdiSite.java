package workshop.day08_jdi;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.jdi_common.enums.HeaderMenu;
import workshop.day07_jdi.pages.MetalsColors;
import workshop.jdi_common.sections.Header;
import workshop.jdi_common.LoginPage;


@JSite("https://epam.github.io/JDI")
public class JdiSite extends WebSite {

    @JPage(url = "/index.html")
    static LoginPage loginPage;

    @JPage("/metals-colors.html")
    static MetalsColors metalsColorsPage;

    @Css(".m-l8")
    static Menu<HeaderMenu> headerMenu;

    @Css(".results")
    public static TextList<Enum> results;

    public static Header header;
}
