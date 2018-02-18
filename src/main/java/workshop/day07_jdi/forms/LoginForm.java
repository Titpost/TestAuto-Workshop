package workshop.day07_jdi.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;
import workshop.day07_jdi.entities.User;

/**
 * Created by Tit.
 */
public class LoginForm extends Form<User> {
    @FindBy(id = "Login")
    private ITextField login;

    @FindBy(id = "Password")
    private ITextField password;

    @FindBy(css = ".btn-login")
    private IButton loginButton;

    public void loginWith(User user) {
        login.newInput(user.login);
        password.newInput(user.password);
        loginButton.click();
    }
}
