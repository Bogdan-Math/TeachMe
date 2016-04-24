package ua.teachme.util.user;

import ua.teachme.model.Role;
import ua.teachme.model.User;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class UserUtil {

    public static List<User> users = Arrays.asList(
            new User(1, "admin", "password", "email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.ADMIN),
            new User(2, "common user", "password", "email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.COMMON),
            new User(3, "anonymous", "password", "email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.ANONYMOUS)
    );
}
