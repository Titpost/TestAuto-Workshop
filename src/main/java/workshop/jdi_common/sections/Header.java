package workshop.jdi_common.sections;

import com.epam.jdi.uitests.core.interfaces.base.IClickable;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.jdi_common.entities.User;
import workshop.jdi_common.forms.LoginForm;


public class Header extends Section {

    @Css(".profile-photo")
    private IClickable expanderButton;

    private LoginForm loginForm;

    /**
     * Expand form then log in
     * @param user to be logged with
     */
    public void loginAs(User user) {
        expanderButton.click();
        loginForm.loginWith(user);
    }
}
