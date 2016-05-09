package ua.teachme.util.user;

import ua.teachme.model.User;
import ua.teachme.util.notation.NotationUtil;

import java.util.Arrays;
import java.util.List;


public class UserUtil {

    public static List<User> users = Arrays.asList(
            new User(null, "admin", "password", "admin@email.com", NotationUtil.hours),
            new User(null, "common user", "password", "common-user@email.com", NotationUtil.hours),
            new User(null, "anonymous", "password", "anonymous@email.com", NotationUtil.hours)
    );


    public static User user = new User(users.get(0));
    public static User newUser = new User(users.get(0));
}
