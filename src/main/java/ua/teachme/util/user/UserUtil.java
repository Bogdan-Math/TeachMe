package ua.teachme.util.user;

import ua.teachme.model.Role;
import ua.teachme.model.User;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class UserUtil {

    public static List<User> users = Arrays.asList(
            new User(null, "admin", "password", "admin-email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.ADMIN),
            new User(null, "common user", "password", "common-user-email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.COMMON),
            new User(null, "anonymous", "password", "anonymous-email", NotationUtil.HOURS_PER_DAY, NotationUtil.NOTATIONS, Role.ANONYMOUS)
    );
}
