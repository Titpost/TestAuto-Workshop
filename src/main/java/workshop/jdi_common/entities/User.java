package workshop.jdi_common.entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User extends DataClass<User> {
    public String login;
    public String password;
}
