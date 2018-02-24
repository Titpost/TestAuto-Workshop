package workshop.jdi_common.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.jdi_common.entities.User;


public class LoginForm extends Form<User> {
    @ById("Login")
    private ITextField login;

    @ById("Password")
    private ITextField password;

    @Css(".btn-login")
    private IButton loginButton;

    public void loginWith(User user) {
        login.newInput(user.login);
        password.newInput(user.password);
        loginButton.click();
    }
}
