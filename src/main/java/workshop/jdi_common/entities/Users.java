package workshop.jdi_common.entities;

public class Users {
    public static final User DEFAULT = new User()
            .set(u->{u.login="epam";u.password="1234";});
    public static User currentUser;
}