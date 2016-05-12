package ua.teachme.util.user;

import ua.teachme.model.User;
import ua.teachme.util.notation.NotationUtil;

import java.util.Arrays;
import java.util.List;

public class UserUtil {

    public static User admin = new User("Admin", "admin-password", "admin@gmail.com", NotationUtil.hours);

    public static User user = new User("User", "user-password", "user@gmail.com", NotationUtil.hours);

    public static User anonymous = new User("Anonymous", "anonymous-password", "anonymous@gmail.com", NotationUtil.hours);

    public static User newUser = new User("NewUser", "user-password", "new-user@gmail.com", NotationUtil.hours);
    public static User equalUser = new User("NewUser", "user-password", "new-user@gmail.com", NotationUtil.hours);

    public static List<User> users = Arrays.asList(
            admin,
            user,
            anonymous
    );
}
