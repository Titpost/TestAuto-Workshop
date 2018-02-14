package workshop.day07_jdi.site;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import org.openqa.selenium.support.FindBy;
import workshop.day07_jdi.enums.HeaderMenu;
import workshop.day07_jdi.site.pages.HomePage;
import workshop.day07_jdi.site.sections.Header;


@JSite("https://www.epam.com")
public class EpamSite extends WebSite {

    @JPage(url = "/", title = "EPAM|Software Product Development Services")
    public static HomePage homePage;

    @FindBy(css = ".top-navigation__list")
    public static Menu<HeaderMenu> headerMenu;

    @JMenu(level1 = @JFindBy(css = "ul.top-navigation__list>li span a"),
            level2 = @JFindBy(css = "ul.top-navigation__grand-sub-list>li a"))
    public static Menu multipleHeaderMenu;


    public static Header header;
}

