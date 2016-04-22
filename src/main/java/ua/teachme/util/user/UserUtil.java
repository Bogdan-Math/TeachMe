package ua.teachme.util.user;

import ua.teachme.model.User;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class UserUtil {

    public static List<User> users = Arrays.asList(
            new User(1, "user name 1", "password", "email", NotationUtil.HOURS_PER_DAY, null, LocalDate.now()),
            new User(2, "user name 2", "password", "email", NotationUtil.HOURS_PER_DAY, null, LocalDate.now()),
            new User(3, "user name 3", "password", "email", NotationUtil.HOURS_PER_DAY, null, LocalDate.now())
    );
}
