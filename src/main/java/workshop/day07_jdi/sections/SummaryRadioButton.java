package workshop.day07_jdi.sections;

import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

public class SummaryRadioButton extends Section {

    @Css("label")
    public ILabel label;
}
