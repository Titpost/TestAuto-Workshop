package workshop.day07_jdi.entities;

import com.epam.commons.DataClass;


/*@AllArgsConstructor*/

public class User extends DataClass<User> {
    public String login;
    public String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }
}
