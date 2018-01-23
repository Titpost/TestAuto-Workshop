package workshop.day04.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


class Header {

    @FindBy(css = ".dropdown")
    SelenideElement elementDropdown;
}
