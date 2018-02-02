package workshop.day04_05.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


class Header {

    @FindBy(css = ".dropdown")
    SelenideElement elementDropdown;
}
