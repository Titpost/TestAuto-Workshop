package workshop.day08_jdi.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;
import workshop.jdi_common.enums.DigitsEnum;

public class Summary extends Section {

    @FindBy(css = "#odds-selector p")
    private RadioButtons<DigitsEnum> odd;

    @FindBy(css = "#even-selector p")
    private Selector<DigitsEnum> even;

    public void select(String digit) {
        if (odd.getValues().contains(digit)) {
            odd.select(digit);
        } else
        if (even.getValues().contains(digit)) {
            even.select(String.valueOf(digit));
        }
    }
}
