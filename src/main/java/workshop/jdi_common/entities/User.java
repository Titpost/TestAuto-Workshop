package workshop.jdi_common.entities;

import com.epam.commons.DataClass;


/*@AllArgsConstructor*/
// TODO lombok ??
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
